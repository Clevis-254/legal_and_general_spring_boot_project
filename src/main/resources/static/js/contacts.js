var contacts = [];
var categoryCount = {
    manager: 0,
    peer: 0,
    external: 0
};
var categoryTargets = {
    manager: 1,
    peer: 5,
    external: 5
};
const COMPRESSED_VIEW_LIMIT = 4;

function addContact() {
    var email = document.getElementById('email').value;
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var category = document.getElementById('category').value;

    if (email && firstName && lastName && category) {
        var contact = {
            email: email,
            firstName: firstName,
            lastName: lastName,
            category: category
        };

        contacts.push(contact);
        updateCategoryCount(category);
        displayContacts();
        clearInputs();
    } else {
        alert('Please fill in all fields.');
    }
}

function displayContacts() {
    var list = document.getElementById('contactsList');
    list.innerHTML = '';

    contacts.forEach(function (contact, index) {
        var card = document.createElement('div');
        card.className = 'bg-gray-200 p-4 rounded-md';

        var contactInfo = document.createElement('div');
        contactInfo.className = 'flex justify-between items-center';

        var contactText = document.createElement('span');
        contactText.className = 'font-semibold';
        if (contacts.length > COMPRESSED_VIEW_LIMIT) {
            contactText.textContent = contact.firstName + ' ' + contact.lastName;
        } else {
            contactText.textContent = contact.firstName + ' ' + contact.lastName + ' - ' + contact.email + ' (' + contact.category + ')';
        }
        contactInfo.appendChild(contactText);

        var deleteButton = document.createElement('button');
        deleteButton.innerHTML = '<i class="bx bx-trash text-red-500"></i>';
        deleteButton.className = 'text-red-500 font-semibold';
        deleteButton.onclick = function () {
            deleteContact(index, contact.category);
        };
        contactInfo.appendChild(deleteButton);

        card.appendChild(contactInfo);
        list.appendChild(card);
    });

    validateSubmission();
}

function deleteContact(index, category) {
    contacts.splice(index, 1);
    updateCategoryCount(category, -1); // Decrease count when contact is deleted
    displayContacts();
}

function clearInputs() {
    document.getElementById('email').value = '';
    document.getElementById('firstName').value = '';
    document.getElementById('lastName').value = '';
    document.getElementById('category').value = '';
}

function updateCategoryCount(category, change = 1) {
    categoryCount[category] += change;
    displayCategoryCount();
}

function displayCategoryCount() {
    var categoryCounts = document.getElementById('categoryCounts');
    categoryCounts.innerHTML = '';

    for (var key in categoryCount) {
        var count = document.createElement('span');
        count.className = 'mr-4';
        count.textContent = key.charAt(0).toUpperCase() + key.slice(1) + ': ' + categoryCount[key] + '/' + categoryTargets[key];
        categoryCounts.appendChild(count);
    }
}

function submitContacts() {
    // Check if minimum counts are met for submission
    if (categoryCount['manager'] >= categoryTargets['manager'] && categoryCount['peer'] >= categoryTargets['peer'] && categoryCount['external'] >= categoryTargets['external']) {
        // Here you can handle the submission of contacts list
        console.log("Contacts:", contacts); // Log contacts list to console for demonstration
        // AJAX request to send contacts to the Spring Boot endpoint
        $.ajax({
            url: '/contacts/add',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(contacts),
            success: function(response) {
                console.log('Contacts sent successfully:', response);
                // Handle success, if needed
            },
            error: function(error) {
                console.error('Error sending contacts:', error);
                // Handle errors, if needed
            }
        });

    } else {
        alert('Minimum counts not met. Please add the required contacts.');
    }
}

function validateSubmission() {
    var submitButton = document.getElementById('submitButton');
    if (categoryCount['manager'] >= categoryTargets['manager'] && categoryCount['peer'] >= categoryTargets['peer'] && categoryCount['external'] >= categoryTargets['external']) {
        submitButton.disabled = false;
    } else {
        submitButton.disabled = true;
    }
}