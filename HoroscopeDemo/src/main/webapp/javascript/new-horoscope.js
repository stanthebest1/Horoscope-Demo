let user = localStorage.getItem('currentUser');

let userJSON = JSON.parse(user);

console.log(userJSON)


//this is going to be anphter fetch function

async function makeNewHoroscope(event){
    event.preventDefault();

    let ticketForm = document.getElementById("description");

    console.log(horoscopeForm);
    console.log(horoscopeForm.value)

    try {
        const raw_response = await fetch(`http://localhost:8080/HoroscopeDemo/horoscopes`,
        {
            method:"POST",

            header: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin":"*",
                "User-id": userJSON.user_Id
            },

            body: JSON.stringify(horoscopeForm.value)

        });
        
        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }

        console.log("Request was completed")

        const json_data = await raw_response.json();

        console.log(json_data);

        alert(`Horoscope #: ${json_data} - Has Been Created`)

        //setTimeout takes an anonymous function

        setTimeout( () => {
            window.location.replace("horoscopes.html")
        },1000)


            
        

    }catch(error){

    }

}