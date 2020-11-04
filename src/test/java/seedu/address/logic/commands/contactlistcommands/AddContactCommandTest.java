package seedu.address.logic.commands.contactlistcommands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ContactList;
import seedu.address.model.Model;
import seedu.address.model.ModuleList;
import seedu.address.model.ReadOnlyContactList;
import seedu.address.model.ReadOnlyEventList;
import seedu.address.model.ReadOnlyModuleList;
import seedu.address.model.ReadOnlyTodoList;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.contact.Contact;
import seedu.address.model.event.Event;
import seedu.address.model.module.Module;
import seedu.address.model.task.Task;
import seedu.address.testutil.ContactBuilder;

public class AddContactCommandTest {

    @Test
    public void constructor_nullContact_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddContactCommand(null));
    }

    @Test
    public void execute_contactAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingContactAdded modelStub = new ModelStubAcceptingContactAdded();
        Contact validContact = new ContactBuilder().build();

        CommandResult commandResult = new AddContactCommand(validContact).execute(modelStub);

        assertEquals(String.format(AddContactCommand.MESSAGE_SUCCESS, validContact), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validContact), modelStub.contactsAdded);
    }

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        Contact contact = new ContactBuilder().build();
        AddContactCommand addContactCommand = new AddContactCommand(contact);
        assertThrows(NullPointerException.class, () -> addContactCommand.execute(null));
    }

    @Test
    public void execute_duplicateContact_throwsCommandException() {
        Contact validContact = new ContactBuilder().build();
        AddContactCommand addContactCommand = new AddContactCommand(validContact);
        ModelStub modelStub = new ModelStubWithContact(validContact);

        assertThrows(CommandException.class,
                AddContactCommand.MESSAGE_DUPLICATE_CONTACT, () -> addContactCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Contact alice = new ContactBuilder().withName("Alice").build();
        Contact bob = new ContactBuilder().withName("Bob").build();
        AddContactCommand addAliceCommand = new AddContactCommand(alice);
        AddContactCommand addBobCommand = new AddContactCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same contact -> returns true
        AddContactCommand addAliceCommandCopy = new AddContactCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(8));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different contact -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getModuleListFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addModule(Module person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setModuleList(ReadOnlyModuleList newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyModuleList getModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyModuleList getModuleListDisplayed() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasModule(Module person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteModule(Module target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setModule(Module target, Module editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Module> getFilteredModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredModuleList(Predicate<Module> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addContact(Contact person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setContactList(ReadOnlyContactList newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyContactList getContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasContact(Contact person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteContact(Contact target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setContact(Contact target, Contact editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Contact> getFilteredContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredContactList(Predicate<Contact> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getContactListFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTodoList(ReadOnlyTodoList newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyTodoList getTodoList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTask(Task target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTask(Task target, Task editedTask) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getFilteredTodoList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredTodoList(Predicate<Task> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getSortedTodoList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateSortedTodoList(Comparator<Task> comparator) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setEventList(ReadOnlyEventList eventList) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyEventList getEventList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasEvent(Event event) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteEvent(Event target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addEvent(Event event) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setEvent(Event target, Event editedEvent) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void undoEventList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void redoEventList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void commitEventList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Event> getFilteredEventList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredEventList(Predicate<Event> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Contact> getSortedContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateSortedContactList(Comparator<Contact> comparator) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void commitModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void redoModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void undoModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void commitContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void redoContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void undoContactList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void commitTodoList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void redoTodoList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void undoTodoList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void commit(int i) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void undo() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void redo() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setArchivedModuleList(ReadOnlyModuleList readOnlyArchivedModuleList) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ModuleList getArchivedModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasArchivedModule(Module module) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteArchivedModule(Module target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addArchivedModule(Module module) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setArchivedModule(Module module, Module editedModule) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void archiveModule(Module target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void unarchiveModule(Module target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void displayArchivedModules() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void displayNonArchivedModules() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList getFilteredArchivedModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList getFilteredUnarchivedModuleList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredArchivedModuleList(Predicate<Module> predicate) {
            throw new AssertionError("This method should not be called.");
        }
        @Override
        public boolean getModuleListDisplay() {
            throw new AssertionError("This method should not be called.");
        }

    }

    /**
     * A Model stub that contains a single contact.
     */
    private class ModelStubWithContact extends ModelStub {
        private final Contact contact;

        ModelStubWithContact(Contact contact) {
            requireNonNull(contact);
            this.contact = contact;
        }

        @Override
        public boolean hasContact(Contact contact) {
            requireNonNull(contact);
            return this.contact.isSameContact(contact);
        }
    }

    /**
     * A Model stub that always accept the contact being added.
     */
    private class ModelStubAcceptingContactAdded extends ModelStub {
        final ArrayList<Contact> contactsAdded = new ArrayList<>();

        @Override
        public boolean hasContact(Contact contact) {
            requireNonNull(contact);
            return contactsAdded.stream().anyMatch(contact::isSameContact);
        }

        @Override
        public void addContact(Contact contact) {
            requireNonNull(contact);
            contactsAdded.add(contact);
        }

        @Override
        public void commitContactList() {}

        @Override
        public ReadOnlyContactList getContactList() {
            return new ContactList();
        }
    }


}
