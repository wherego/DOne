package com.dzy.done.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

import com.dzy.done.R;
import com.dzy.done.asynctask.ClearCacheTask;
import com.dzy.done.config.AppSetting;

/**
 *  设置界面
 */
public class SettingFragment extends PreferenceFragment
{



    public static SettingFragment newInstance()
    {
        return new SettingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getPreferenceManager().setSharedPreferencesName("setting");
        addPreferencesFromResource(R.xml.setting);

        getPreferenceScreen().findPreference("FontSize").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue)
            {
                AppSetting.getSetting().setFontSize(Integer.parseInt((String)newValue));
                return true;
            }
        });

        ((SwitchPreference)getPreferenceScreen().findPreference("NightMode")).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue)
            {
                boolean night = (boolean) newValue;
                AppSetting.getSetting().setNightMode(night);
                getActivity().recreate();
                return true;
            }
        });

    }


    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference)
    {

        //如果选中了清除缓存
        if (preference.getKey().equals("clearCache"))
        {
            new ClearCacheTask().execute();
            return true;
        }else if (preference.getKey().equals("GitHub"))
        {
            String url = (String) preference.getSummary();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }

        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

}
