function selectionSort( array ){
    for ( let i = 0 ; i < array.length; i++ ){
        let minIndex = findMinIndex( array, i , compareFirstName ); // input diff compare function
        let temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}

function findMinIndex( array, iteration, compareFunc ){
    let minIndex = iteration;
    for ( let i = iteration + 1; i < array.length; i++ ){
        if( compareFunc( array[i] , array[minIndex] ) ){
            minIndex = i;
        }
    }
    return minIndex;
}

function compareTo( a, b ){
    return( a < b );
}

function compareLastName( a, b ){
    return( a.lastName < b.lastName );
}

function compareFirstName( a, b ){
    return( a.firstName < b.firstName);
}

function main(){

    // test sorting
    let arrayInt = [ 3, 70, 29, -10];
    let arrayFloat = [ 3.3, 70.2, 29.8, -10.8];
    let arrayString = [ 'ZEBRA','dog', 'zebra', 'Dog', 'cat'];
    let arrayMix = [ 'apple', 70, 1.7, 'Ace'];

    selectionSort( arrayInt );
    selectionSort( arrayFloat );
    selectionSort( arrayString );
    selectionSort( arrayMix );
    console.log( arrayInt );
    console.log( arrayFloat );
    console.log( arrayString );
    console.log( arrayMix );

    let person1 = { 'firstName': 'Jinny', 'lastName': 'Jeng' };
    let person2 = { 'firstName': 'Jennifer', 'lastName': 'Lopez' };
    let person3 = { 'firstName': 'Yili', 'lastName': 'Hsu' };
    let person4 = { 'firstName': 'Cyan', 'lastName': 'Hsu' };
    let personArray = [ person1, person2, person3, person4 ];

    selectionSort( personArray );
    console.log( personArray );

}
window.onload = main;