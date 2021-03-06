package graphql.kickstart.graphql.annotations;

import graphql.kickstart.graphql.annotations.exceptions.MultipleMutationResolversException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContextException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Test exception if multiple mutation resolvers are defined.")
public class GraphQLAnnotationsErrorMultipleMutationResolvers {

    @Test
    @DisplayName("Assert that MultipleMutationResolversException is thrown when multiple mutation resolvers are found.")
    public void testMultipleMutationResolversExceptionIsThrown() {
        // GIVEN
        final SpringApplication app = new SpringApplication(TestApplication.class);
        app.setAdditionalProfiles("test", "test-multiple-mutation-resolvers-exception");
        // WHEN - THEN
        assertThatExceptionOfType(ApplicationContextException.class)
            .isThrownBy(app::run)
            .withRootCauseExactlyInstanceOf(MultipleMutationResolversException.class);
    }
}
