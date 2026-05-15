<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>System Performance Monitor</title>
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Share+Tech+Mono&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/styles.css" />
    <script src="js/script.js" defer></script>
  </head>

  <body>
    <main class="container neon-panel">
      <header class="app-header">
        <h2 class="neon-title">SYSTEM PERFORMANCE<br>MONITOR</h2>
        <p class="subtitle">Cybernetic warning console &bull; add warnings and keep your systems alive</p>
      </header>

      <form method="post" class="log-form" action="add">
        <h3 class="form-title">Inject a new warning</h3>
        
        <div class="form-control">
          <label for="sysName">SYSTEM NAME</label>
          <input type="text" id="sysName" name="systemName" placeholder="CPU" autocomplete="off" />
        </div>

        <div class="form-control">
          <label for="msg">WARNING MESSAGE</label>
          <input type="text" id="msg" name="warningMessage" placeholder="High Temperature" autocomplete="off" />
        </div>

        <div class="form-control">
          <label for="severity">SEVERITY LEVEL</label>
          <div class="select-wrapper">
            <select id="severity" name="severityLevel">
              <option value="Low" selected>Low</option>
              <option value="Medium">Medium</option>
              <option value="High">High</option>
              <option value="Critical">Critical</option>
            </select>
          </div>
        </div>

        <div class="buttons">
          <button type="submit" formaction="add" onclick="return handleAdd();" class="btn btn-primary">
            ADD WARNING
          </button>
          
          <button type="submit" formaction="count" class="btn btn-secondary">
            COUNT WARNINGS
          </button>
          
          <button type="submit" formaction="display" class="btn btn-secondary">
            DISPLAY WARNINGS
          </button>
          
          <button type="submit" formaction="filter" class="btn btn-secondary">
            FILTER CRITICAL
          </button>
        </div>
      </form>
      
      <p class="footer-text">Tap into the monitoring grid. Keep the system stable. Keep it neon.</p>

      <div class="terminal-wrapper">
        <textarea
          class="terminal-output"
          readonly
          spellcheck="false"
          placeholder="System grid active..."
        >${logs}</textarea>
      </div>
    </main>

    <div id="popupOverlay" class="popup-overlay">
      <div class="popup-box neon-panel">
        <div class="popup-icon" id="popupIcon"></div>
        <h3 id="popupTitle" class="popup-title">Message</h3>
        <p id="popupMessage" class="popup-message"></p>
        <button onclick="closePopup()" class="btn btn-primary btn-block">
          ACKNOWLEDGE
        </button>
      </div>
    </div>

    <div id="server-message" style="display: none">
      <%= request.getAttribute("popup") == null ? "" : request.getAttribute("popup") %>
    </div>
    
    <script>
      window.onload = function () {
        var msg = document.getElementById("server-message").innerText;
        if (msg && msg.trim() !== "") {
          showPopup(msg, msg.toLowerCase().includes("success") || msg.toLowerCase().includes("total") ? "success" : "error");
        }
      };
    </script>
  </body>
</html>
