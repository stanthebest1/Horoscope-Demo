let user = localStorage.getItem("register");

let myUser = JSON.stringify(user);
console.log(myUser);

console.log(myUser.username);

let greeting = document.getElementById("greeting");

greeting.innerHTML = `Welcome, ${myUser.firstName}!`;

// CREATE FETCH FUNC TO GET MOOD (CHANGE BODY)
async function getMood() {

    let sign = document.getElementById("sign-input").value;

    console.log(sign, sign.value);

    try {

        const raw_resp = await fetch(`http://sandipbgt.com/theastrologer/api/horoscope/${sign}/today`);

        console.log("Made it past FETCH!");

        if (!raw_resp.ok) {
            throw new Error(raw_resp.status)
        }

        console.log("Request was completed.")

        const data = await raw_resp.json();

        console.log(data);

        // RENDERING
        let mood = document.getElementById("mood");
        mood.append("Mood: " + data.meta.mood);
        mood.append(document.createElement("br"));

        let horoscope = document.getElementById("horoscope");
        horoscope.append("Horoscope: " + data.horoscope);
        horoscope.append(document.createElement("br"));


        // setTimeout uses ANONYMOUS FUNCTION
        setTimeout(() => {
            window.location.reload;
        }, 1000);

    } catch (error) {
        console.log(error)
    }

};

// User LogOut Function
function logOut() {
    localStorage.removeItem('currentUser');
    window.location.replace("index.html")
}