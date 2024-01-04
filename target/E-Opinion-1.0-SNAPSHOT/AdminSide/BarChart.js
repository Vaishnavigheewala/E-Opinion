document.addEventListener('DOMContentLoaded', function () {
    // Bar Chart Data
    var barData = {
        labels: ["Pollution", "Voting", "Education", "Health", "Research"],
        datasets: [{
            label: 'Bar Chart',
            data: [1, 0, 0 , 2, 1],
            backgroundColor: [
                'rgba(255, 99, 132, 0.5)',
                'rgba(54, 162, 235, 0.5)',
                'rgba(255, 206, 86, 0.5)',
                'rgba(75, 192, 192, 0.5)',
                'rgba(153, 102, 255, 0.5)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'
            ],
            borderWidth: 1
        }]
    };

    // Bar Chart Options
    var barOptions = {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    };

    // Create Bar Chart
    var barChartCanvas = document.getElementById('barChart').getContext('2d');
    new Chart(barChartCanvas, {
        type: 'bar',
        data: barData,
        options: barOptions
    });

    // Pie Chart Data
    var pieData = {
        labels: ["Good", "Avarage", "Avarage", "Very Good", "Good"],
        datasets: [{
            label: 'Pie Chart',
            data: [1, 0, 0 , 2, 1],
            backgroundColor: [
                'rgba(255, 99, 132, 0.5)',
                'rgba(54, 162, 235, 0.5)',
                'rgba(255, 206, 86, 0.5)',
                'rgba(75, 192, 192, 0.5)',
                'rgba(153, 102, 255, 0.5)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'
            ],
            borderWidth: 1
        }]
    };

    // Create Pie Chart
    var pieChartCanvas = document.getElementById('pieChart').getContext('2d');
    new Chart(pieChartCanvas, {
        type: 'pie',
        data: pieData
    });
});

//doughnut

var ctx = document.getElementById('donutChart').getContext('2d');
    var donutChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: ["Pollution", "Voting", "Education", "Health", "Research"],
            datasets: [{
                data: [25, 0, 0, 50, 25],
                backgroundColor: ['rgba(255, 99, 132, 0.6)', 'rgba(54, 162, 235, 0.6)', 'rgba(255, 206, 86, 0.6)',                'rgba(75, 192, 192, 0.5)',
                'rgba(153, 102, 255, 0.5)'
],
                borderColor: ['rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)','rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'],
                borderWidth: 1
            }]
        }
    });
