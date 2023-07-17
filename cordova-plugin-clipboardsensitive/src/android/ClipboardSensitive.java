package cordova.plugin.clipboardSensitive;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.*;
import android.os.PersistableBundle;
import android.content.ClipData;

public class ClipboardSensitive extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        
        if (action.equals("setSensitiveClipboard")) {
            String text = data.getString(0);
            Context context=this.cordova.getActivity().getApplicationContext();
            ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            
            ClipData clip = ClipData.newPlainText("Label", text);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                clip.getDescription().getExtras().putBoolean(ClipDescription.EXTRA_IS_SENSITIVE, true);
            } else {
                clip.getDescription().getExtras().putBoolean("android.content.extra.IS_SENSITIVE", true);
            }
            clipboard.setPrimaryClip(clip);
            
            callbackContext.success(); // Thread-safe.
            return true;
        }
        
        return false;  // Returning false results in a "MethodNotFound" error.
    }
}
