<b>Spring Boot Demo</b>

Spring Boot tutorial https://www.youtube.com/watch?v=vtPkZShrvXQ&t=5230s

<li>Build it using:</li>
<code>mvn clean install</code>
<br><br>
<li>To run this, install docker and docker-compose.</li>
<code>docker-compose up</code>
<br><br>
<li>Now, get the postgres container id using</li>
<code>docker ps</code>
<br><br>
<li>Get into to the posgres-container and execute the script.</li>
<code>docker exec -it POSTGRES_CONTAINER_ID "sh"</code>
<br>
<code>sh /tmp/postgres_starter_script.sh</code>
<br><br>
<li>The application is live now!</li>