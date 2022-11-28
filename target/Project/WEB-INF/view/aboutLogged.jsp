<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.11.2022
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>About Us</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/CSS/styles.css"/>">
</head>
<body>


<nav class style="margin-top: 3%;">
    <div class="buttons">
        <a href="home">Home</a>
        <a href="about">About Us</a>
        <a href="order">Order</a><img src="<c:url value="/resources/Images/buy.png"/>" class="icon" alt="Img"/>
        <a href="profile">Profile</a>
        <a href="logout">Logout</a>
        <a href=""><img src="<c:url value="/resources/Images/facebook.png"/>" class="facebook facebookLogged" alt="Img"/></a>
        <a href=""><img src="<c:url value="/resources/Images/instagram.png"/>" class="instagram instagramLogged" alt="Img"/></a>
    </div>

</nav>


<header>
    <a href="home">
        <font>Gustoso</font>
        <img src="<c:url value="/resources/Images/logo.png"/>" alt="Img"/>
    </a>
</header>


<section>
    <article>
        <div class="aboutUs">
            <p class="welcome">Welcome <br>to Gustoso</p>
            <hr>
            <p>Gustoso is a stylish Italian bar and restaurant in the Center of Chisinau city from Moldova.
                <br>
                <br>
                Brought to you by Chisinau Restaurants who have the popular Italian trattorias of Al Duca in St James and Osteria dell’Angolo in Chisinau.
                <br>
                <br>
                Gustoso promises contemporary as well as classic Italian dishes, served by a knowledgeable, passionate team to lovers of Italian food.
                <br>
                <br>
                Our menus feature fresh, seasonal ingredients and include daily specials both at lunch and dinner.
                <br>
                <br>
                Dear Guests, if you have problems or questions, you can call us on 022 4134 8579 or email us on info@gustoso.md
                <br>
                <br>
                <b>Working Hours</b>
                <br>Monday 08:00 - 21:00
                <br>Tuesday 08:00 - 21:00
                <br>Wednesday 08:00 - 21:30
                <br>Thursday 08:00 - 21:30
                <br>Friday 8:00-22:00
                <br>Saturday 07:00 - 23:00
                <br>Sunday 07:00 - 23:00
            </p>
            <br>
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5439.471169211728!2d28.842535472347233!3d47.02579498655774!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40c97c3592efa02d%3A0x4e32729505411b65!2zQ3LDqG1lIGRlIGxhIENyw6htZQ!5e0!3m2!1sen!2s!4v1668870836636!5m2!1sen!2s" width="500" height="350" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            <br>
            <br>
            <br>
        </div>
    </article>
    <div class="main">
        <img src="<c:url value="/resources/Images/main.jpg"/>" alt="Img"/>
    </div>
</section>

<footer>
</footer>


</body>
</html>