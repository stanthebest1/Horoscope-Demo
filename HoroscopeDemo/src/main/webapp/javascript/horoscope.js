let user = localStorage.getItem('currentUser');

//we are going to parse our value to JSON
let userJSON = JSON.parse(user);
console.log(userJSON)

//instead if using 
//We also use the async and await keyword with the fetch() method. 
//The async keyword is added to functions to tell them to return a promise rather than directly returning the value. 
//The await keyword only works inside async functions, 
//used to pause the code on that line until promise gets complete.


async function getHoroscopes(){


    try{

        // here we will need to add the await keyword in order for us to be able to get out response back
        //why? because the function can comlete before the data we are requesting has come back to us

        const raw_response = await fetch(`http://localhost:8080/HoroscopeDemo/horoscopes`,
        
        {
            //http verb
            method:"GET",
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*",
                "User-Id": userJSON.user_id
            }

            //here if this was a post request this is where we would add our body
        }
        
        
        
        
        );

        //check that we have received a successful response

        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }

        //since this is an asynchronous functinon it will complete before we get a response back
        //that is why we have to tell it to 'await'

        const json_data = await raw_response.json();

        //log it

        //save this token into session storage available 

    localStorage.setItem("horoscopes",JSON.stringify(json_data));
    
    //here we are calling the function to render our html
    //meaning here we will show the tickets we got back from our database
    renderHoroscopes(json_data);
        
    }catch(error){

        console.log(error);

    }
}
 function renderHoroscopes(horoscopelist){

    //make a ref to the element on out html page

    let orderedList = document.getElementById("horoscope-list");

    //here we are going to iterate through the array that we should get back
    horoscopelist.array.froEach(element => {
        //here we are creating a new list element for each element in our ticketList
        //aka the array 
        let item = document.createElement("li");
        item.innerText = `${element.ticket_Id}---${element.description}---${element.user_id}`

        orderedList.append(item);


    });

 }