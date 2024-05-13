// Define an array with country data
const countries = [
    {
        name: "Default Country",
        flagImage: "usa.jpg",
        backgroundColor: "#ff3366",
    },
    {
        name: "USA",
        flagImage: "usa.jpg",
        backgroundColor: "#ff3366",
    },
    {
        name: "Germany",
        flagImage: "germany.jpg",
        backgroundColor: "#6633ff",
    },
    {
        name: "Ghana",
        flagImage: "ghana.png",
        backgroundColor: "#33ff66",
    },
    {
        name: "Guatemala",
        flagImage: "guatemala.png",
        backgroundColor: "#ff9900",
    },
    {
        name: "India",
        flagImage: "india.jpg",
        backgroundColor: "#ffcc00",
    },
    {
        name: "Mexico",
        flagImage: "mexico.jpg",
        backgroundColor: "#ff6666",
    },
    {
        name: "Nepal",
        flagImage: "nepal.png",
        backgroundColor: "#ff9933",
    },
];

// Function to update the page based on the selected country
function updatePage(countryName) {
    const country = countries.find((c) => c.name.toLowerCase() === countryName);

    if (!country) {
        // If the country is not found, use the default country data
        const defaultCountry = countries[0];
        document.getElementById("flag-image").src = defaultCountry.flagImage;
        document.body.style.background = defaultCountry.backgroundColor;
        document.getElementById("country-name").textContent = defaultCountry.name;
    } else {
        // Update the image source, background color, and country name
        document.getElementById("flag-image").src = `pictures/${country.flagImage}`;
        document.body.style.background = country.backgroundColor;
        document.getElementById("country-name").textContent = country.name;
    }
}

// Event listener for the Submit button
document.getElementById("submit-button").addEventListener("click", function () {
    const countryInput = document.getElementById("country-input").value.toLowerCase();
    updatePage(countryInput);
});
