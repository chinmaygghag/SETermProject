var clicker = document.getElementById("clickme");
clicker.onclick = function() {
  document.getElementById("drawer").className = "mdl-layout__drawer"; // only keep mdl-layout__drawer, is-visible should be removed
}