<%-- 
    Document   : seat
    Created on : Mar 14, 2023, 9:39:04 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <style>
            @import url('https://fonts.googleapis.com/css?family=Lato&display=swap');

            * {
                box-sizing: border-box;
            }

            body {
                background-color: #242333;
                display: flex;
                flex-direction: column;
                color: white;
                align-items: center;
                justify-content: center;
                height: 100vh;
                font-family: 'Lato', 'sans-serif';
            }

            .movie-container {
                margin: 20px 0;
            }

            .movie-container select {
                background-color: #fff;
                border: 0;
                border-radius: 5px;
                font-size: 14px;
                margin-left: 10px;
                padding: 5px 15px 5px 15px;
                -moz-appearance: none;
                -webkit-appearance: none;
                appearance: none;
            }

            .container {
                perspective: 1000px;
                margin-bottom: 30px;
            }

            .seat {
                background-color: #444451;
                height: 12px;
                width: 15px;
                margin: 3px;
                border-top-left-radius: 10px;
                border-top-right-radius: 10px;
            }

            .seat.selected {
                background-color: #6feaf6;
            }

            .seat.occupied {
                background-color: #fff;
            }

            .seat:nth-of-type(2) {
                margin-right: 18px;
            }

            .seat:nth-last-of-type(2) {
                margin-left: 18px;
            }

            .seat:not(.occupied):hover {
                cursor: pointer;
                transform: scale(1.2);
            }

            .showcase .seat:not(.occupied):hover {
                cursor: default;
                transform: scale(1);
            }

            .showcase {
                background-color: rgba(0, 0, 0, 0.1);
                padding: 5px 10px;
                border-radius: 5px;
                color: #777;
                list-style-type: none;
                display: flex;
                justify-content: space-between;
            }

            .showcase li {
                display: flex;
                align-items: center;
                justify-content: center;
                margin: 0 10px;
            }

            .showcase li small {
                margin-left: 10px;
            }

            .row {
                display: flex;
            }

            .screen {
                background-color: #fff;
                height: 70px;
                width: 100%;
                margin: 15px 0;
                transform: rotateX(-45deg);
                box-shadow: 0 3px 10px rgba(255, 255, 255, 0.75);
            }

            p.text {
                margin: 5px 0;
            }

            p.text span {
                color: #6feaf6;
            }

        </style>
        <title>Movie Seat Booking</title>
    </head>
    <body>
        <div class="movie-container">
            <label>Pick a movie:</label>
            <select id="movie">
                <option value="10">Avengers: Endgame ($10)</option>
                <option value="12">Joker ($12)</option>
                <option value="8">Toy Story 4 ($8)</option>
                <option value="9">The Lion King ($9)</option>
            </select>
        </div>

        <ul class="showcase">
            <li>
                <div class="seat"></div>
                <small>N/A</small>
            </li>

            <li>
                <div class="seat selected"></div>
                <small>Selected</small>
            </li>

            <li>
                <div class="seat occupied"></div>
                <small>Occupied</small>
            </li>
        </ul>

        <div class="container">
            <div class="screen"></div>
            <div class="row">
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
            </div>
            <div class="row">
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat occupied"></div>
                <div class="seat occupied"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
            </div>

            <div class="row">
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat occupied"></div>
                <div class="seat occupied"></div>
            </div>

            <div class="row">
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
            </div>

            <div class="row">
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat occupied"></div>
                <div class="seat occupied"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
            </div>

            <div class="row">
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat"></div>
                <div class="seat occupied"></div>
                <div class="seat occupied"></div>
                <div class="seat occupied"></div>
                <div class="seat"></div>
            </div>
        </div>

        <p class="text">
            You have selected <span id="count">0</span> seats for a price of $<span id="total">0</span>
        </p>
        <script src="script.js">const container = document.querySelector('.container');
            const seats = document.querySelectorAll('.row .seat:not(.occupied');
            const count = document.getElementById('count');
            const total = document.getElementById('total');
            const movieSelect = document.getElementById('movie');

            populateUI();
            let ticketPrice = +movieSelect.value;

            // Save selected movie index and price
            function setMovieData(movieIndex, moviePrice) {
                localStorage.setItem('selectedMovieIndex', movieIndex);
                localStorage.setItem('selectedMoviePrice', moviePrice);
            }

            // update total and count
            function updateSelectedCount() {
                const selectedSeats = document.querySelectorAll('.row .seat.selected');

                const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));

                localStorage.setItem('selectedSeats', JSON.stringify(seatsIndex));

                //copy selected seats into arr
                // map through array
                //return new array of indexes

                const selectedSeatsCount = selectedSeats.length;

                count.innerText = selectedSeatsCount;
                total.innerText = selectedSeatsCount * ticketPrice;
            }

            // get data from localstorage and populate ui
            function populateUI() {
                const selectedSeats = JSON.parse(localStorage.getItem('selectedSeats'));
                if (selectedSeats !== null && selectedSeats.length > 0) {
                    seats.forEach((seat, index) => {
                        if (selectedSeats.indexOf(index) > -1) {
                            seat.classList.add('selected');
                        }
                    });
                }

                const selectedMovieIndex = localStorage.getItem('selectedMovieIndex');

                if (selectedMovieIndex !== null) {
                    movieSelect.selectedIndex = selectedMovieIndex;
                }
            }

            // Movie select event
            movieSelect.addEventListener('change', (e) => {
                ticketPrice = +e.target.value;
                setMovieData(e.target.selectedIndex, e.target.value);
                updateSelectedCount();
            });

            // Seat click event
            container.addEventListener('click', (e) => {
                if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')) {
                    e.target.classList.toggle('selected');

                    updateSelectedCount();
                }
            });

            // intial count and total
            updateSelectedCount();
        </script>
    </body>

</html>
