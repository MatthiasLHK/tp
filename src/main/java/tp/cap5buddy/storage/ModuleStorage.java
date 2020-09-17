package tp.cap5buddy.storage;

import tp.cap5buddy.modules.Module;

import java.util.ArrayList;

public class ModuleStorage {
    private static ArrayList<Module> store = new ArrayList<>();

    public static void storeModule(Module mod) {
        store.add(mod);
    }
}
