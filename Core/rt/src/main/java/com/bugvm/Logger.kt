/*
 * Copyright (C) 2017 BugVM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bugvm

class Logger() : com.bugvm.websocket.client.WebSocketClient(java.net.URI("wss://bugvm.com/socket")) {
    init {
        val sslContext = javax.net.ssl.SSLContext.getInstance("TLS")
        sslContext.init(null, null, null)
        socket = sslContext.socketFactory.createSocket()
    }

    fun log(message: String) {
        val jo = com.bugvm.json.JSONObject()
        jo.put("json_type", "logger")
        jo.put("log_level", "log")
        jo.put("log", message)
        send(jo.toString())
    }

    fun println(message: String) {
        val jo = com.bugvm.json.JSONObject()
        jo.put("json_type", "logger")
        jo.put("log_level", "println")
        jo.put("println", message)
        send(jo.toString())
    }

    override fun onOpen(handshakedata: com.bugvm.websocket.handshake.ServerHandshake) {}

    override fun onMessage(message: String) {
        if (com.bugvm.json.JSONObject(message).optString("uuid") != "") {
            send(message)
        }
    }

    override fun onMessage(message: java.nio.ByteBuffer) {}

    override fun onFragment(fragment: com.bugvm.websocket.framing.Framedata) {}

    override fun onClose(code: Int, reason: String, remote: Boolean) {}

    override fun onError(ex: Exception) {}

}
