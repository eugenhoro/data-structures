var fs = require('global-fs');
var a = require('./a');
function f(x) {
      var a = require('./b');
}
function func1()
{
    var local1 = 10;

    global1 = 20;
}

obj1 = {
    objFunc1 : function()
    {
        var local2 = 30;
    },
    objProp1 : "prop1"
}