/*
 * Copyright (C) 2016 BugVM
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/gpl-2.0.html>.
 */
package com.bugvm.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Sim {

    public String showdevicetypes() {

        String[] names = GetAvailableNames();
        ArrayList<String> list= new ArrayList<String>(Arrays.asList(names));

        String command_runtime = "xcrun simctl list runtimes | egrep '^i' | egrep -v 'unavailable'| awk '{print $2}'";
        String[] cmd_runtime = {
                "/bin/bash",
                "-c",
                command_runtime
        };

        String runtimes = executeCommand(cmd_runtime).trim();

        String command = "xcrun simctl list devicetypes | egrep '^i' | awk -F 'com.apple.CoreSimulator.SimDeviceType.' '{print $1 \"YY) \" $2}' | awk '{print substr($0, 1, length($0)-1)}'\n";
        String[] cmd = {
                "/bin/bash",
                "-c",
                command
        };

        String showdevicetypes = "";

        String devicetypes = executeCommand(cmd);
        String[] lines = devicetypes.split("\n");
        for(String line : lines) {
            String[] parts = line.split("\\(YY\\)");
            String out = "";
            String match = parts[1].trim();
            if(match.equals("iPhone-4s") || match.equals("iPhone-5") || match.equals("iPad-2") || match.equals("iPad-Retina") )
                out = "com.apple.CoreSimulator.SimDeviceType." +match +", "+runtimes + ", (i386)";
            else out = "com.apple.CoreSimulator.SimDeviceType." +match +", "+runtimes + ", (x86_64 i386)";

            if(list.contains(parts[0].replace("-"," ").trim())) showdevicetypes += out +"\n";
        }

        return showdevicetypes;
    }

    public void start() {
        String command_start = "killall Simulator; xc=$(xcode-select -p) ; open $xc/Applications/Simulator.app";
        String[] cmd_start = {
                "/bin/bash",
                "-c",
                command_start
        };

        executeCommand(cmd_start);
    }

    public  void launch(String path_to_app, String device_type_id) {

        String app_identifier = GetCFBundleIdentifier(path_to_app);

        String udid = GetUDIDFromSimDeviceType(device_type_id);

        String command_start = "killall Simulator; xc=$(xcode-select -p) ; open -a $xc/Applications/Simulator.app --args -CurrentDeviceUDID "+udid;
        String[] cmd_start = {
                "/bin/bash",
                "-c",
                command_start
        };
        executeCommand(cmd_start);

        int counter = 0;
        int timeout_seconds = 30;
        while (counter < timeout_seconds) {
            String command = "xcrun simctl spawn booted launchctl print system | grep com.apple.springboard.services | grep -v grep";
            String[] cmd = {
                    "/bin/bash",
                    "-c",
                    command
            };
            String OPEN = executeCommand(cmd);
            if(!OPEN.contains("com.apple.springboard.services")) {
                counter = counter +1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else break;

        }

        //install app
        String command_install = "xcrun simctl install booted "+path_to_app;
        String[] cmd_install = {
                "/bin/bash",
                "-c",
                command_install
        };
        executeCommand(cmd_install);
        //launch app
        String command_launch = "xcrun simctl launch booted "+app_identifier;
        String[] cmd_launch = {
                "/bin/bash",
                "-c",
                command_launch
        };
        executeCommand(cmd_launch);

    }

    String GetNameFromSimDeviceType (String devicetypeid) {

        String Name="";
        String[] lines = devicetypeid.split(",");
        String typeid = lines[0].trim();
        String version = lines[1].trim();

        String command = "xcrun simctl list devicetypes | egrep '^i'";
        String[] cmd = {
                "/bin/bash",
                "-c",
                command
        };

        String results = executeCommand(cmd).trim();
        lines = results.split("\n");
        String[] parts;
        for(String line : lines)
        {
            parts = line.split("\\(com.apple.CoreSimulator.SimDeviceType.");

            Name = parts[0].trim();

            String simdevicetype = "com.apple.CoreSimulator.SimDeviceType."+parts[1].replace(")","");
            if(typeid.equalsIgnoreCase(simdevicetype)) return Name;

        }

        return Name;
    }

    String GetCFBundleIdentifier(String path_to_app) {

        String info = "Info.plist";
        String command = " plutil -p '" + path_to_app + "/Info.plist' | grep 'CFBundleIdentifier'";
        String[] cmd = {
                "/bin/bash",
                "-c",
                command
        };

        String results = executeCommand(cmd).trim();
        String[] lines = results.split("\n");
        String udid = lines[0].replace("\"","");
        String[] udids = udid.split("=>");

        String CFBundleIdentifier = udids[1].trim().replace("\"","");
        System.out.println(CFBundleIdentifier);

        return  CFBundleIdentifier;
    }

    String GetUDIDFromName(String Name) {

        //ipad Pro names fixes
        Name = Name.replace("-"," ");

        String command = "xcrun simctl list devices | egrep -v 'unavailable'| egrep '^\\s+i' | grep '"+Name+" ('";
        String[] cmd = {
                "/bin/bash",
                "-c",
                command
        };

        String results = executeCommand(cmd).trim();
        String[] lines = results.split("\n");
        String udid = lines[0].replace(Name,"");
        String[] udids = udid.split("\\) \\(");

        String UDID = udids[0].replace("(","").trim();

        return  UDID;
    }

    String[] GetAvailableNames() {

        String command = "xcrun simctl list devices | egrep -v 'unavailable'| egrep '^\\s+i'";
        String[] cmd = {
                "/bin/bash",
                "-c",
                command
        };

        String results = executeCommand(cmd).trim();
        String[] lines = results.split("\n");
        String[] names = new String[lines.length];
        for(int i=0; i < lines.length;i++) {
            names[i] = lines[i].split("\\([0-9A-F]{8}-[0-9A-F]{4}-[0-9A-F]{4}-[0-9A-F]{4}-[0-9A-F]{12}\\)")[0].trim();
        }

        return  names;
    }

    String GetUDIDFromSimDeviceType(String type) {
        String n = GetNameFromSimDeviceType(type);
        //ipad has "-" or " " in names
        return GetUDIDFromName(n.replace("-"," "));
    }

    String executeCommand(String[] command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command, null, null);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}