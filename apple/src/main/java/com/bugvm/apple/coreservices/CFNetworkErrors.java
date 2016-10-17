/*
 * Copyright (C) 2013-2015 RoboVM AB
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
package com.bugvm.apple.coreservices;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.corefoundation.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
public enum /*<name>*/CFNetworkErrors/*</name>*/ implements ValuedEnum {
    No(0L),
    /*<values>*/
    HostErrorHostNotFound(1L),
    HostErrorUnknown(2L),
    SOCKSErrorUnknownClientVersion(100L),
    SOCKSErrorUnsupportedServerVersion(101L),
    SOCKS4ErrorRequestFailed(110L),
    SOCKS4ErrorIdentdFailed(111L),
    SOCKS4ErrorIdConflict(112L),
    SOCKS4ErrorUnknownStatusCode(113L),
    SOCKS5ErrorBadState(120L),
    SOCKS5ErrorBadResponseAddr(121L),
    SOCKS5ErrorBadCredentials(122L),
    SOCKS5ErrorUnsupportedNegotiationMethod(123L),
    SOCKS5ErrorNoAcceptableMethod(124L),
    FTPErrorUnexpectedStatusCode(200L),
    ErrorHTTPAuthenticationTypeUnsupported(300L),
    ErrorHTTPBadCredentials(301L),
    ErrorHTTPConnectionLost(302L),
    ErrorHTTPParseFailure(303L),
    ErrorHTTPRedirectionLoopDetected(304L),
    ErrorHTTPBadURL(305L),
    ErrorHTTPProxyConnectionFailure(306L),
    ErrorHTTPBadProxyCredentials(307L),
    ErrorPACFileError(308L),
    ErrorPACFileAuth(309L),
    ErrorHTTPSProxyConnectionFailure(310L),
    StreamErrorHTTPSProxyFailureUnexpectedResponseToCONNECTMethod(311L),
    URLErrorBackgroundSessionInUseByAnotherProcess(-996L),
    URLErrorBackgroundSessionWasDisconnected(-997L),
    URLErrorUnknown(-998L),
    URLErrorCancelled(-999L),
    URLErrorBadURL(-1000L),
    URLErrorTimedOut(-1001L),
    URLErrorUnsupportedURL(-1002L),
    URLErrorCannotFindHost(-1003L),
    URLErrorCannotConnectToHost(-1004L),
    URLErrorNetworkConnectionLost(-1005L),
    URLErrorDNSLookupFailed(-1006L),
    URLErrorHTTPTooManyRedirects(-1007L),
    URLErrorResourceUnavailable(-1008L),
    URLErrorNotConnectedToInternet(-1009L),
    URLErrorRedirectToNonExistentLocation(-1010L),
    URLErrorBadServerResponse(-1011L),
    URLErrorUserCancelledAuthentication(-1012L),
    URLErrorUserAuthenticationRequired(-1013L),
    URLErrorZeroByteResource(-1014L),
    URLErrorCannotDecodeRawData(-1015L),
    URLErrorCannotDecodeContentData(-1016L),
    URLErrorCannotParseResponse(-1017L),
    URLErrorInternationalRoamingOff(-1018L),
    URLErrorCallIsActive(-1019L),
    URLErrorDataNotAllowed(-1020L),
    URLErrorRequestBodyStreamExhausted(-1021L),
    URLErrorAppTransportSecurityRequiresSecureConnection(-1022L),
    URLErrorFileDoesNotExist(-1100L),
    URLErrorFileIsDirectory(-1101L),
    URLErrorNoPermissionsToReadFile(-1102L),
    URLErrorDataLengthExceedsMaximum(-1103L),
    URLErrorSecureConnectionFailed(-1200L),
    URLErrorServerCertificateHasBadDate(-1201L),
    URLErrorServerCertificateUntrusted(-1202L),
    URLErrorServerCertificateHasUnknownRoot(-1203L),
    URLErrorServerCertificateNotYetValid(-1204L),
    URLErrorClientCertificateRejected(-1205L),
    URLErrorClientCertificateRequired(-1206L),
    URLErrorCannotLoadFromNetwork(-2000L),
    URLErrorCannotCreateFile(-3000L),
    URLErrorCannotOpenFile(-3001L),
    URLErrorCannotCloseFile(-3002L),
    URLErrorCannotWriteToFile(-3003L),
    URLErrorCannotRemoveFile(-3004L),
    URLErrorCannotMoveFile(-3005L),
    URLErrorDownloadDecodingFailedMidStream(-3006L),
    URLErrorDownloadDecodingFailedToComplete(-3007L),
    HTTPCookieCannotParseCookieFile(-4000L),
    NetServiceErrorUnknown(-72000L),
    NetServiceErrorCollision(-72001L),
    NetServiceErrorNotFound(-72002L),
    NetServiceErrorInProgress(-72003L),
    NetServiceErrorBadArgument(-72004L),
    NetServiceErrorCancel(-72005L),
    NetServiceErrorInvalid(-72006L),
    NetServiceErrorTimeout(-72007L),
    NetServiceErrorDNSServiceFailure(-73000L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/CFNetworkErrors/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/CFNetworkErrors/*</name>*/ valueOf(long n) {
        for (/*<name>*/CFNetworkErrors/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/CFNetworkErrors/*</name>*/.class.getName());
    }
}
