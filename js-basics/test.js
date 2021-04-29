var links = document.getElementsByTagName("a");

for(i=0;i<links.length;i++){
    links[i].className = "link-"+i;    
}

function getAverage(a,b){
    var average = (a+b)/2;
    console.log(average);
}

getAverage(20,23);

function sum(a,b){
    var sum = a+b;
    return sum;
}

var returnSum = sum(20,23);

console.log(returnSum);

var stringValue="deneme"

console.log(typeof(returnSum));
console.log(typeof(stringValue));
console.log(typeof(stringValue));


var a=7;
var b=5;

console.log(Math.round(7.5));
console.log(Math.round(7.3));
console.log(Math.floor(7.5));
console.log(Math.floor(7.3));
console.log(Math.ceil(7.3));
console.log(Math.ceil(7.5));
console.log(Math.max(a,b));
console.log(Math.PI);


var c="6";

console.log(a+c);
console.log(a*c);

var d="apple";

console.log(a*d);

if(isNaN(d)){
    console.log("d is not a number");
    
}

var myString = "I \'m a string";
console.log(myString);
console.log(myString.length);
console.log(myString.toUpperCase());
console.log(myString.indexOf("string"));

var string1="abc";
var string2="abc";

if(string1===string2){
    console.log("they are equals");
}

var myArray=[12,23,"hi","mucahit"];
console.log(myArray);

myArray[0]=14;

console.log(myArray.sort);


//define object -- version 1
var car = new Object();

car.maxSpreed=50; 
car.driver = "asdsa";

console.log(car.driver);


car.drive = function(){ console.log("i am now driving");}

car.drive();

//define object -- version 2

var car2 = {
    model: "bmw",
    maxSpeed : 300,
    driver : "asad",
    drive : function(){
        console.log("i am now driving the car2"); },
    drive2 : function(speed,time){ console.log(speed * time)},
    drive3 : function(){ console.log(this);},
    getCarModel : function(){ console.log(this.model);}
};

car2.drive();
car2.drive2(10,4);
car2.drive3();
car2.getCarModel();


var car3 = {
    model: "bmw",
    maxSpeed : 400,
    driver : "bla bla",
    drive : function(){
        console.log("i am now driving the car2"); },
    drive2 : function(speed,time){ console.log(speed * time)},
    drive3 : function(){ console.log(this);},
    getCarModel : function(){ console.log(this.model);}
};


var Car = function(maxSpped,driver){
    this.maxSpeed = maxSpped;
    this.driver = driver;
    this.drive2 = function(speed,time){ console.log(speed * time);};
    this.drive3 = function(){ console.log(this);};
}

var myCar = new Car(200,"adad");
myCar.drive3();

var myDate = new Date();
console.log(myDate);


var yo =document.getElementById("yo");

yo.onclick=function(){
    alert("you clicked me");
}

