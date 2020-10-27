package seedu.address.logic.parser.schedulerparsers;

import seedu.address.logic.commands.modulelistcommands.AddModuleCommand;
import seedu.address.logic.commands.schedulercommands.AddEventCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventName;
import seedu.address.model.event.EventTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

public class AddEventParser implements Parser<AddEventCommand> {
    @Override
    public AddEventCommand parse(String userInput) throws ParseException {
        ArgumentTokenizer tokenizer = new ArgumentTokenizer(userInput, PREFIX_NAME, PREFIX_DATE);
        ArgumentMultimap argMultiMap = tokenizer.tokenize();
        if (!arePrefixesPresent(argMultiMap, PREFIX_NAME, PREFIX_DATE)
                || !argMultiMap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddEventCommand.MESSAGE_USAGE));
        }
        EventName name = new EventName(argMultiMap.getValue(PREFIX_NAME).get());
        String dateTime = argMultiMap.getValue(PREFIX_DATE).get();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-uuuu HHmm");
        LocalDateTime dT = LocalDateTime.parse(dateTime,formatter);
        EventTime time = new EventTime(dT);
        Event event = new Event(name, time);
        return new AddEventCommand(event);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
