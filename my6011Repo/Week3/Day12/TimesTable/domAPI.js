function main(){

    // title
    document.getElementsByTagName('title')[0].textContent = "Lab8 - Interactive Multiplication Table";

    // create times table
    let table = document.createElement('table');

    // table basic style
    table.setAttribute('border', '1');
    table.setAttribute('align', 'center');
    table.style.marginTop = '60px';

    let clickID = null;
    let clickData = null;

    // table data
    for( let row = 1; row <= 10; row++ ){
        let tableRow = document.createElement('tr'); // table row

        for ( let col = 1; col <= 10; col++ ){

            let tableData = document.createElement('td');
            let tdText = document.createTextNode( row * col );
            tableData.appendChild( tdText );
            tableRow.appendChild( tableData );
            tableData.id = row.toString() + col.toString();

            // text style
            tableData.style.padding = '12px';
            tableData.style.fontSize = '20px';
            tableData.style.textAlign = 'center';
            tableData.style.fontFamily = 'Andale Mono';

            // data event
            tableData.addEventListener('mouseover',function(){
                tableData.className = 'highlighted';
            });

            tableData.addEventListener('mouseout',function(){
                tableData.removeAttribute('class');
            });

            tableData.addEventListener('click',function(){

               if( clickID != null ){
                   clickData.style.background = 'transparent';
               }
               tableData.style.background = 'lightblue';
               clickID = tableData.id;
               clickData = document.getElementById( clickID );

            });
        }
        table.appendChild(tableRow);
    }
    document.body.appendChild(table);


    // background color
    window.setInterval(changeBgColor, 10);
    let btnClick = false;
    let i = 0;
    let upGradient = true;

    function changeBgColor(){
        document.body.style.background = `rgb(${100+i},${i},${200-i})`;
        if(btnClick) {
            if (i == 255) {
                upGradient = false;
            } else if (i == 0) {
                upGradient = true;
            }
            if (upGradient) {
                i++;
            } else {
                i--;
            }
        }
    }

    // color button
    let colorBtn = document.createElement("button");
    colorBtn.textContent = "Change color";
    document.body.appendChild(colorBtn);
    // button style
    colorBtn.style.marginLeft = '200px';
    colorBtn.style.marginTop = '50px';
    colorBtn.style.padding = '10px';
    // click on button
    colorBtn.addEventListener('click',function(){
        if( btnClick ){
            btnClick = false;
        }else{
            btnClick = true;
        }
    })

}

window.onload = main;