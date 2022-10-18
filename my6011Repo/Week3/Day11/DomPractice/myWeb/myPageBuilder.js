function main(){
    // title
    document.getElementsByTagName('title')[0].textContent = "CS6011 Lab7";

    // body > div ( h1 + h2) + hr
    let myDiv = document.createElement('div');
    let myH1 = document.createElement('h1');
    let myH2 = document.createElement('h2');
    let myHr = document.createElement('hr');

    let h1Text = document.createTextNode("Utah National Parks");
    let h2Text = document.createTextNode("Like Picasso's blue period, Utah national parks are variations on a theme - petrified Jurassic sediments sculpted by wind, water and time - but each one exhilarates in its own way.");

    myH1.appendChild(h1Text);
    myH2.appendChild(h2Text);
    myDiv.appendChild(myH1);
    myDiv.appendChild(myH2);
    document.body.appendChild(myDiv);
    document.body.appendChild(myHr);

    // p + br
    let myP = document.createElement('p');
    let myBr = document.createElement('br');
    let pText = document.createTextNode('These are 4 national parks I\'m going to visit this fall break.')

    myP.appendChild(pText);
    myP.appendChild(myBr);
    document.body.appendChild(myP);

    // ol > li + img + iframe +a
    let myOl = document.createElement('ol');
    let li1 = document.createElement('li');
    let li2 = document.createElement('li');
    let li3 = document.createElement('li');
    let li4 = document.createElement('li');
    let myImg = document.createElement('img');
    let myIframe = document.createElement('iframe');
    let myA = document.createElement('a');


    let li1Text = document.createTextNode('Zion National Park');
    let li2Text = document.createTextNode('Bryce Canyon National Park');
    let li3Text = document.createTextNode('Canyonlands National Park');
    let li4Text = document.createTextNode('Arches National Park');

    myImg.width = 420;
    myImg.height = 215;
    myImg.src = "http://res.cloudinary.com/simpleview/image/upload/v1601421684/clients/utahddm/_66d4d4c3-5ff8-416b-8ee4-fe462a5a40aa.2576c93235.jpg";

    myIframe.width = 420;
    myIframe.height = 315;
    myIframe.src = "https://www.youtube.com/embed/na77XEMTyNI";

    myA.href = "https://www.utah.com/destinations/national-parks/";
    let myAText = document.createTextNode('This is my reference website.')

    li1.appendChild(li1Text);
    li2.appendChild(li2Text);
    li3.appendChild(li3Text);
    li4.appendChild(li4Text);
    myA.appendChild(myAText);
    myOl.appendChild(li1);
    myOl.appendChild(li2);
    myOl.appendChild(li3);
    myOl.appendChild(li4);
    myOl.appendChild(myP.cloneNode());
    myOl.appendChild(myImg);
    myOl.appendChild(myBr.cloneNode());
    myOl.appendChild(myIframe);
    myOl.appendChild(myBr.cloneNode());
    myOl.appendChild(myA);
    document.body.appendChild(myOl);

    // Style
    document.body.style.background = '#646B79';
    document.body.style.fontFamily = "Andale Mono";
    document.body.style.padding = '100px';
    myP.style.color = '#FFF00D';

}

window.onload = main;