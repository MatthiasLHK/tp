package tp.cap5buddy.parser;

import tp.cap5buddy.commands.AddModule;

public abstract class AddModuleParser {
    public static String execute(String name, String link) {
        return AddModule.execute(name, link);
    }
}
