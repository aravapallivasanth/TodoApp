$(document).ready(function()
    {                
        $('save').click(function(event)
        {
        	alert('Hello World!')
            event.preventDefault();
            id = $('input[name="id"]').attr('id'); // get value of input text id
            priority = $('input[name="priority"]').val(); // get value of input text priority
            todo = $('input[name="todo"]').val(); // get value of input text todo
            
            $.ajax({ // Send request
                type: "POST", 
                url: 'http://localhost:8080/save', 
                data: {id: id, priority: priority, todo:todo}, //Id, priority, and todo are referent
                cache: false,
                success: function(response){
                    if(response=="success"){ // updaterow return "success" or echo "success"
                        $('#1 td:nth-child(1)').text(id);
						$('#1 td:nth-child(2)').text(priority);
                        $('#1 td:nth-child(3)').text(todo);
                    }
                },
             });
         });
    });