# sudoku-ws
<h1>Summary</h1>
<p>Simple rest service to test successive moves on a sudoku</p>

<h1>Prerequisites</h1>
<h2>Maven</h2>
<p>You need to have maven installed. You can check <a href='https://www.mkyong.com/maven/how-to-install-maven-in-windows/' target="_blank">this url</a> to help you with that.</p>

<h1>Overview</h1>
<ul>
  <li><b>Resource Url:</b> http://localhost:8080/</li>
  <li><b>Request Methods:</b> REST(GET)</li>
  <li><b>Response Format:</b> JSON </li>
  <li><b>Respose encoding:</b> UTF-8</li>
</ul>

<h1>Sudoku</h1>
<p>
Request <br>
<ul>
<li><b>/sudoku : </b> Default call to endpoint, returning the default state and grid of the excercise.</li>
<li><b>/sudoku/{state} : </b>You can configure the content of the grid base in a hypen separated string representing the number in base-36</li>
<li><b>/sudoku/{state}/move/{move} :</b> Rest url to call when performing a move on the particular state of the sudoku.</li>
</ul>
</p>

<p>
Response <br>
<ul>
<li><b>grid : </b> Contains a graphic representation of the sudoku.</li>
<li><b>state : </b> The current state of the sudoku, after performing the call to /move/</li>
<li><b>previousState :</b> Previous state of the sudoku.</li>
<li><b>solved : </b> Flag that represents if the sudoku is solved or not.</li>
<li><b>validGrid : </b> Simple flag that is false when there is an invalid call to move, and the current gird is invalid.</li>
</ul>
</p>

<h1>How to run</h1>
<p>
You can run it, after you have maven installed, using the command <br>
<pre><code>
mvn test spring-boot:run
</code></pre>
</p>
