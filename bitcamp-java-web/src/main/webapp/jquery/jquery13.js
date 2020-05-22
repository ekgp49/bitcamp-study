function jQuery(selector) {
  if(selector.startsWith('<')) {
    var tagName = selector.substring(1, selector.length - 1);
    var el = [document.createElement(tagName)];
  } else {
    var el = document.querySelectorAll(selector);
  }
  el.html = function(value) {
    if(arguments.length == 0){
      return this[0].innerHTML;
    }
    for (var e of el) {
      e.innerHTML = value;
    }
    return this;
  };
  
  el.addClass = function(value) {
    if(arguments.length == 0){
      return this;
    }
    for (var e of el) {
      e.className = e.className + " " + value;
    }
    return this;
  };

  
  el.css = function(name, value) {
    if (arguments.length == 0) {
      return;
    }
    if(arguments.length == 1){
      return this[0].style[name];
    }
    for (var e of el) {
      e.style[name] = value;
    }
    return this;
  };
  
  el.on = function(event, p1, p2) {
    if (arguments.length < 2) {
      return;
    }
    
    if (arguments.length == 2) {
      for (var e of el) {
        e.addEventListener(event, p1);
      }
    } else {
      for (var element of el) {
        element.addEventListener(event, (e) => {
          // 부모의 자식중에서 파라미터에서 지정한 셀렉터일 경우에만 
          // 리스너를 호출한다.
          var targets = element.querySelectorAll(p1);
          
          for (var target of targets) {
            if (e.target == target) {
              p2(e);
            }
          }
        });
      }
    }
    return this;
  }
  
  el.click = function(listener) {
    if (arguments.length < 1) {
      return;
    }
    this.on('click', listener);
    return this;
  }
  
  el.append = function(childs) {
    if (arguments.length < 1) {
      return;
    }
    for (var e of el) {
      for (var child of childs) {
        e.appendChild(child);
      }
    }
    return this;
  }
  
  el.appendTo = function(parents) {
    if (arguments.length < 1) {
      return;
    }
    for (var parent of parents) {
      for (var e of el) {
        parent.appendChild(e);
      }
    }
    return this;
  }
  
  return el;
};

var $ = jQuery;

