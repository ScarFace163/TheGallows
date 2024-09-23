package backend.academy;

import backend.academy.model.Session;
import backend.academy.model.Word;
import backend.academy.service.SessionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SessionServiceTest {
    private SessionServiceImpl sessionService;
    private Session session;

    @BeforeEach
    public void setup() {
        sessionService = new SessionServiceImpl();
        session = mock(Session.class);
    }

    @Test
    public void testIsGameEnded() {
        when(session.currentAttemptsNumber()).thenReturn(5);
        when(session.maxAttemptsNumber()).thenReturn(5);
        assertTrue(sessionService.isGameEnded(session));

        char[] testWord = {'t', 'e', 's', 't'};
        when(session.answer()).thenReturn(new Word(testWord, "test", 1));
        char[] currentGuess = {'_', '_', '_', '_'};
        when(session.currentGuess()).thenReturn(currentGuess);
        when(session.currentAttemptsNumber()).thenReturn(4);
        when(session.maxAttemptsNumber()).thenReturn(5);
        assertFalse(sessionService.isGameEnded(session));
    }

    @Test
    public void testCheckLetter() {
        char[] testWord = {'t', 'e', 's', 't'};
        when(session.answer()).thenReturn(new Word(testWord, "test", 1));
        assertTrue(sessionService.checkLetter(session, "t"));
        assertFalse(sessionService.checkLetter(session, "x"));
    }

    @Test
    public void testUseHint() {
        sessionService.useHint(session);
        verify(session).isHintUsed(true);
    }
}
