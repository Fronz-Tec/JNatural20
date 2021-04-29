


function diceThrow(){

    let sides = document.getElementById("diceSides").value;
    let amount = document.getElementById("diceAmount").value;
    let modifier = parseInt(document.getElementById("diceModifier").value);
    let diceResult = "";
    let calculatedThrow;

    for(let i = 1; i <= amount; i++){

        let temp = Math.floor(Math.random() * sides + 1);
        diceResult += "Dice " + i + ": <b>" + temp;

        calculatedThrow = temp + modifier;

        if(modifier < 0){

            diceResult += " <i>( " + modifier + " ) ( " + calculatedThrow + " ) </i></b><br>";

        }else if(modifier > 0){

            diceResult += "<i> ( +" + modifier + " ) ( " + calculatedThrow + " ) </i></b><br>";

        }else if(modifier == 0){

            //TODO: Something
            diceResult += "</b><br>";
        }

    }

    document.getElementById("diceResult").innerHTML = diceResult;


}

function generateRandomEncounter(){
    alert("Coming Soon");
}

function createNPC(){

    //let names = ["Grif Quiecack","Elp Tarkus","Franc","Arel Lera","Lord Ipsum"];

    //TODO: Change to Markov Chain Text Generator for absolute random names

   // let professions = ["Blacksmith","Beggar","Bard","Farmer","Butcher","Soldier","Guard","Knight","Magician"];

   // let specialLook = ["Missing Teeth","Different Colored Eyes","Missing Arm","Missing Leg","Missing Eye","No Hair","Long Nose"];

   // let maxNPCAge = document.getElementById("NPCAgeRange").value;

  //  let chanceOfSpecialLookRange = document.getElementById("chanceOfSpecialLookRange").value;

  //  let npcAge = Math.floor(Math.random() * maxNPCAge + 1);

  //  let isNPCSpecial = Math.floor(Math.random() * 10 + 1);

    //let npcName = names[Math.floor(Math.random() * names.length)];

    generateNameFromList();

   // let npcProfession = professions[Math.floor(Math.random() * professions.length)];

   // let npcSpecialLook;

   // if(isNPCSpecial >= chanceOfSpecialLookRange){

    //   npcSpecialLook = specialLook[Math.floor(Math.random() * specialLook.length)];

    ///}else{
    //    npcSpecialLook = "None";
    //}

    //document.getElementById("NPCAge").innerHTML = "<b>Age: </b>" + npcAge;
    //document.getElementById("NPCProfession").innerHTML = "<b>Profession: </b>" + npcProfession;
   // document.getElementById("NPCSpecial").innerHTML = "<b>Special: </b>" + npcSpecialLook;


}






let order = 3;
let ngrams = {};
let beginnings = [];
let nameForNPC;
let chainLength = 20;

function generateNameFromList(){
    // names = loadStrings('../data/names.txt');

    // let names = require('fs');
    //
    // $.readFile('../data/names.txt', 'utf8');

    let names = new XMLHttpRequest();
    names.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            ngram(this);

        }
    };
    names.open("GET", "./data/names.txt", true);
    names.send();


    // console.log(names);


}



function ngram(names){

    names = names.response.toString().split("\n");

    for(let j = 0; j < names.length; j++) {

        nameForNPC = names[j];

        // console.log(data);

        for (let i = 0; i <= nameForNPC.length - order; i++) {

            let gram = nameForNPC.substring(i, i + order);

            if(i === 0){
                beginnings.push(gram);
            }

            if (!ngrams[gram]) {
                ngrams[gram] = [];
            }
            ngrams[gram].push(nameForNPC.charAt(i + order));
        }
    }
    // console.log(ngrams);
    chainText(nameForNPC);
}

function chainText(nameForNPC){

    //let currentGram = data.substring(0, order);
    let currentGram = random(beginnings);
    let result = currentGram;

    for(let i = 0; i <= chainLength; i++){

        let possibilities = ngrams[currentGram];

        if(!possibilities){
            break;
        }

        let nextChar = random(possibilities);

        result += nextChar;

        currentGram = result.substring(result.length - order, result.length);

    }

    console.log(result);
    document.getElementById("NPCName").value = result;
}

function random(array){
    let item = array[Math.floor(Math.random()*array.length)];

    return item;
}