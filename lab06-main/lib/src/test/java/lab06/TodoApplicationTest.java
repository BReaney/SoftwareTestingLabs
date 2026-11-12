
package lab06;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.mockito.internal.matchers.Any;

import java.util.List;

class TodoApplicationTest {

    private TodoApplication todoApp;
    private PersonService personServiceMock;
    private TodoService todoServiceMock;

    private final String userName = "SomeUser";
    private final Long userID = 1L;
    private final List<String> todos = List.of("Wake up", "Test the code", "Celebrate the victory!");

    @Test
    void addTodo() {
        //Create the mock todoService and personService
        TodoService todoServiceMock = mock(TodoService.class, withSettings().verboseLogging());
        PersonService personServiceMock = mock(PersonService.class, withSettings().verboseLogging());
        //Using the mocks, make the dummy
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);
        //when you call the addTodo, if it works properly and calls the method then return true
        boolean result = todoApp.addTodo(userID,todos.get(0));
        //verify the addTodo Method for the service was called only once
        verify(todoServiceMock, times(1)).addTodo(any(), any());
        verifyNoMoreInteractions(todoServiceMock);
        //verify the search by ID was called
        verify(personServiceMock, times(1)).findUsernameById(any());
        verifyNoMoreInteractions(personServiceMock);


        //all works, does call all required methods.




        // Ensure that it's possible to add a todo to the app, and that the correct methods are called
    }

    @Test
    void retrieveTodos() {
        //create the mock services for use in the dummy
        TodoService todoServiceMock = mock(TodoService.class, withSettings().verboseLogging());
        PersonService personServiceMock = mock(PersonService.class, withSettings().verboseLogging());
        //make the dummy
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);
        //when called by the username, return SomeUser
        when(personServiceMock.findUsernameById(userID)).thenReturn("SomeUser");
        //when calling the retrieve todoservice, return list of todos contained
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(todos);
        //sorting by the keyword, we should only have the two strings that contain "the"
        assertThat(todoApp.retrieveTodos(userID, "the")).containsExactly("Test the code", "Celebrate the victory!");

        // add multiple todos to the app, and retrieve a strict subset of them using a substring.
    }

    @Test
    void completeAllWithNoTodos() {
        TodoService todoServiceMock = mock(TodoService.class, withSettings().verboseLogging());
        PersonService personServiceMock = mock(PersonService.class, withSettings().verboseLogging());

        todoApp = new TodoApplication(todoServiceMock, personServiceMock);
        // confirm that the appropriate behaviour occurs when there are no todos being tracked by the app
        //assuming the appropriate behaviour would be calling the todoservice.retrievetodos once, and then if its null ending the cycle.
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(null);
        //call completeAllTodos...
        todoApp.completeAllTodos(userID);
        //make sure we don't enter into the for loop if we have no todos.
        verify(todoServiceMock, times(0)).completeTodo(any());
    }

    @Test
    void completeAllWithThreeTodos() {
        TodoService todoServiceMock = mock(TodoService.class, withSettings().verboseLogging());
        PersonService personServiceMock = mock(PersonService.class, withSettings().verboseLogging());

        todoApp = new TodoApplication(todoServiceMock, personServiceMock);
        // confirm that the appropriate behaviour occurs when there are three todos being tracked by the app
        //we need to call todoservice.completetodos once for each of the todos in our list, in this case three
        //setup like in retrieve todos test...
        when(personServiceMock.findUsernameById(userID)).thenReturn("SomeUser");
        //when calling the retrieve todoservice, return list of todos contained
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(todos);

        //call completeAllTodos
        todoApp.completeAllTodos(userID);
        //make sure we call completetodo 3 times
        verify(todoServiceMock, times(3)).completeTodo(any());

    }
}