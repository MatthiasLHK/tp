package tp.cap5buddy.parser;

import java.util.Scanner;

public class Parser {
    private String userInput;
    private String reply;
    private String command;

    public Parser() {
        this.userInput = null;
        this.reply = null;
        this.command = null;
    }

    public void setUserInput(String input) {
        this.userInput = input;
        setCommand();
        parse();
    }

    public String getReply() {
        return this.reply;
    }

    private void parse() { // this is the breaking down part, current set to echo user input.
        String name = getName();
        String link = getLink();
        if(this.command.equals("add")){
            this.reply = AddModuleParser.execute(name, link);
        } else {
            this.reply = this.userInput;
        }
    }

    private void setCommand() {
        Scanner sc = new Scanner(this.userInput);
        this.command = sc.next();
    }

    private String getName() {
        Scanner sc = new Scanner(this.userInput);
        sc.next();
        return sc.next();
    }

    private String getLink() {
        Scanner sc = new Scanner(this.userInput);
        sc.next();
        sc.next();
        return sc.next();
    }
}
