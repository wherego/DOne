package com.dzy.done.fregment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

import com.dzy.done.R;
import com.dzy.done.asynctask.ClearCacheTask;
import com.dzy.done.config.AppSetting;

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
    }



    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference)
    {

        if (preference.getKey().equals("clearCache"))
        {
            new ClearCacheTask().execute();
            return true;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }


}
