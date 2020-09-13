package tp.cap5buddy.parser;

public class Parser {
    private String userInput;
    private String reply;
    public Parser() {
        this.userInput = null;
        this.reply = null;
    }

    public void setUserInput(String input) {
        this.userInput = input;
        parse();
    }

    public String getReply() {
        return this.reply;
    }

    private void parse() { // this is the breaking down part, current set to echo user input.
        this.reply = this.userInput;
    }
}
