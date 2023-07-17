var exec = require('cordova/exec');

exports.setSensitiveClipboard = function(text, onSuccess, onError) {
    exec(onSuccess, onError, 'ClipboardSensitive', 'setSensitiveClipboard', [text]);
};
