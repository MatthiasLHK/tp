package tp.cap5buddy.modules;

import java.util.List;

/**
 * Encapsulates information and methods that relate to a list of modules being tracked.
 */
public class ModuleList {

    /** List of modules belonging to the user. **/
    private final List<Module> modules;

    /**
     * Creates and initialises a new ModuleList object.
     *
     * @param modules List of modules.
     */
    public ModuleList(List<Module> modules) {
        this.modules = modules;
    }

    /**
     * Retrieves the module matching the input module name from the list of modules.
     *
     * @param index Zero based index of the module.
     * @return Module matching the input module name if it exists, null otherwise.
     */
    public Module getModule(int index) {
        Module module = this.modules.get(index);
        return module;
    }

    /**
     * Adds a module.
     *
     * @param module
     */
    public void addModule(Module module) {
        this.modules.add(module);
    }

    /**
     * Returns the size of the list.
     * @return integer size.
     */
    public int getListSize() {
        return this.modules.size();
    }

    /**
     * Updates a module in the list of modules at the given index.
     *
     * @param index Zero based index of the module in the list of modules.
     * @param module Updated module to replace the old module in the list of modules.
     */
    public void updateModule(int index, Module module) {
        this.modules.set(index, module);
    }
}

