package phonebook.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import phonebook.model.User;

import java.util.stream.Stream;

public class UsersProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new User("manuelgm.com", "Manuel1234$")),
                Arguments.of(new User("manuel@g.com", "Manuel1234$")),
                Arguments.of(new User("manuel@go.com", "masdfa1$")),
                Arguments.of(new User("manuel@go.com", "MASdfa1")),
                Arguments.of(new User("manuel@go.com", "MASdfa$"))
        );
    }
}
