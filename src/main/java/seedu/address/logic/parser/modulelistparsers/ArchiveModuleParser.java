package seedu.address.logic.parser.modulelistparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.modulelistcommands.ArchiveModuleCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ArchiveModuleCommand object.
 */
public class ArchiveModuleParser implements Parser<ArchiveModuleCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ArchiveModuleCommand
     * and returns a ArchiveModuleCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public ArchiveModuleCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new ArchiveModuleCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ArchiveModuleCommand.MESSAGE_USAGE), pe);
        }
    }
}
