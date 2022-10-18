document.writeln( "<p> hello world </p>" );
console.log( "hello world console" ); // not show on browser, only for testing

// create array of diff variables
let myArray = [ "book", true, 3, 2.1, {} ];
console.log( myArray ); // also output the modified value...

// modify the value of array
myArray[2] = 10;
console.log( myArray );

// 2 ways to define function
function myFunction1( a, b ){ return a + b };  // has function name
let myFunction2 = function ( a, b ){ return a + b };  // no func name, save function into a variable

console.log( myFunction1(2,3) );
console.log( myFunction1(2.2,3.3) );
console.log( myFunction1("oh","no") );
console.log( myFunction1(2.2,"no") );

console.log( myFunction2(2,3) );
console.log( myFunction2(2.2,3.3) );
console.log( myFunction2("oh","no") );
console.log( myFunction2(2.2,"no") );