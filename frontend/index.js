// script.js
const fetchUserDataButton = document.getElementById('fetchUserDataButton');
const resultUserDiv = document.getElementById('resultUserDiv');

const fetchConstructionDataButton = document.getElementById('fetchConstructionDataButton');
const resulConstructiontDiv = document.getElementById('resulConstructiontDiv');

// Function to make an API request using a promise
function fetchData() {
    return new Promise((resolve, reject) => {
        // Replace 'YOUR_API_URL' with the actual URL of your microservice
        fetch("http://localhost:8081/v1/user/getinfo/m1234")
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                reject('Failed to fetch data');
            })
            .then(data => resolve(data))
            .catch(error => reject(error));
    });
}

fetchUserDataButton.addEventListener('click', () => {
    fetchData()
        .then(data => {
            resultUserDiv.innerHTML = `<p>API Response: ${JSON.stringify(data)}</p>`;
        })
        .catch(error => {
            resultUserDiv.innerHTML = `<p>Error: ${error}</p>`;
        });
});

//----------- for construction
// Function to make an API request using a promise
function fetchConstructionData() {
    return new Promise((resolve, reject) => {
        // Replace 'YOUR_API_URL' with the actual URL of your microservice
        fetch("http://localhost:8080/v1/construction/retrieve/1")
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                reject('Failed to fetch data');
            })
            .then(data => resolve(data))
            .catch(error => reject(error));
    });
}

fetchConstructionDataButton.addEventListener('click', () => {
    fetchConstructionData()
        .then(data => {
            resulConstructiontDiv.innerHTML = `<p>API Response: ${JSON.stringify(data)}</p>`;
        })
        .catch(error => {
            resulConstructiontDiv.innerHTML = `<p>Error: ${error}</p>`;
        });
});
