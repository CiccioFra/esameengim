const div = document.getElementById('container');
div.id = "dic";
div.className += "dic contenitore";

console.log("cio");

const table = document.createElement('table');
table.className += "table";

// const tr = document.createElement('tr');
// const th = document.createElement('th');
// const td = document.createElement('td');

// const p = document.createElement('p');
// p.innerText = "cella";

// th.append(p);
// tr.append(th);

// td.append(p);
// tr.append(td);

// table.append(tr);

// div.append(table);

const url = 'http://localhost:8081/ordini';

fetch(url)
    .then((response) => {
        console.log(response);
        console.log(response.json());
        console.log("dentro primo then");
        return response.json();
    })
    .then((data) => {
        console.log("dentro secondo then");

        let articoli = data;
        console.log(data);
        console.log(data.json());

        console.log(articoli);
        console.log(articoli.json());

        articoli.map(function (articolo) {
            let tr = document.createElement('tr');
            let td = document.createElement('td');
            let td2 = document.createElement('td');
            let td3 = document.createElement('td');

            td.innerHTML = `${articolo.id}`;
            td2.innerHTML = `${articolo.td2}`;
            td3.innerHTML = `${articolo.td3}`;

            tr.appendChild(td);
            tr.appendChild(td2);
            tr.appendChild(td3);
            table.appendChild(tr);
        });
    })
    .catch(function (error) {
        console.log(error);
    });


