
document.getElementById("feedbackForm").addEventListener("submit", async function (event) {
    event.preventDefault();

    const message = document.getElementById("message");
    const submitButton = document.querySelector(
        '#feedbackForm button[type="submit"]'
    );

    const feedback = {
        studentId: parseInt(document.getElementById("studentId").value, 10),
        facultyName: document.getElementById("facultyName").value.trim(),
        subjectName: document.getElementById("subjectName").value.trim(),
        rating: parseInt(document.getElementById("rating").value, 10),
        comments: document.getElementById("comments").value.trim()
    };

    message.textContent = "Submitting feedback...";
    message.style.color = "blue";

    if (submitButton) {
        submitButton.disabled = true;
    }

    try {
        const response = await fetch(
            "https://student-feedback-backend-jm7x.onrender.com/api/feedback",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(feedback)
            }
        );

        if (!response.ok) {
            throw new Error("Server returned status " + response.status);
        }

        message.textContent = "Feedback submitted successfully!";
        message.style.color = "green";

        document.getElementById("feedbackForm").reset();
        document.getElementById("studentId").value = 1;

    } catch (error) {
        message.textContent =
            "Could not submit feedback. Please try again.";
        message.style.color = "red";

        console.error("Feedback submission error:", error);
    } finally {
        if (submitButton) {
            submitButton.disabled = false;
        }
    }
});
