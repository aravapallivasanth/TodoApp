package com.todo;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.todo.util.Priority;

/**
 * This Junit class yet to be completed. Work is in progress.
 * @author vasanth
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class TodoControllerTest {
 
    private MockMvc mockMvc;
 
    @Autowired
    @Qualifier(value="todoController")
    private TodoController todoServiceMock;
 
    //Add WebApplicationContext field here.
 
    //The setUp() method is omitted.
    
 
    @Ignore
    public void findAll_TodosFound_ShouldReturnFoundTodoEntries() throws Exception {
        ToDo first = new ToDo(1, Priority.High, "Pay credit card bill");
                
        ToDo second = new ToDo(2, Priority.Medium, "Book tickets");
 
        when(todoServiceMock.getTodoList()).thenReturn(Arrays.asList(first, second));
 
        mockMvc.perform(get("/getTodoList"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect((ResultMatcher) jsonPath("$[0].id", Matchers.anyInt()))
                .andExpect(jsonPath("$[0].priority", is(Priority.High)))
                .andExpect(jsonPath("$[0].todo", is("Pay credit card bill")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].priority", is(Priority.Medium)))
                .andExpect(jsonPath("$[1].todo", is("Book tickets")));
 
        verify(todoServiceMock, times(1)).getTodoList();
        verifyNoMoreInteractions(todoServiceMock);
    }
}
