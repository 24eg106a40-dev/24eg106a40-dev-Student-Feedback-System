document.getElementById("feedbackForm").addEventListener("submit", function(event) {

    event.preventDefault();

    const feedback = {
        studentId: parseInt(document.getElementById("studentId").value),
        facultyName: document.getElementById("facultyName").value,
        subjectName: document.getElementById("subjectName").value,
        rating: parseInt(document.getElementById("rating").value),
        comments: document.getElementById("comments").value
    };

    fetch("http://localhost:8080/api/feedback", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(feedback)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Failed to submit feedback");
        }
        return response.json();
    })
    .then(data => {

        document.getElementById("message").textContent =
            "Feedback submitted successfully!";

        document.getElementById("message").style.color = "green";

        document.getElementById("feedbackForm").reset();

        document.getElementById("studentId").value = 1;
    })
    .catch(error => {

        document.getElementById("message").textContent =
            "Error submitting feedback.";

        document.getElementById("message").style.color = "red";

        console.error(error);
    });
});