package com.depeng;


import java.util.Set;

public class HowToBind {
    public static void main(String[] args) {
//        LoggerFactory

//        private final static void bind() {
//            try {
//                Set staticLoggerBinderPathSet = findPossibleStaticLoggerBinderPathSet();
//                reportMultipleBindingAmbiguity(staticLoggerBinderPathSet);
//                // the next line does the binding
//                StaticLoggerBinder.getSingleton();
//                INITIALIZATION_STATE = SUCCESSFUL_INITIALIZATION;
//                reportActualBinding(staticLoggerBinderPathSet);
//                emitSubstituteLoggerWarning();
//            } catch (NoClassDefFoundError ncde) {
//                String msg = ncde.getMessage();
//                if (messageContainsOrgSlf4jImplStaticLoggerBinder(msg)) {
//                    INITIALIZATION_STATE = NOP_FALLBACK_INITIALIZATION;
//                    Util.report("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
//                    Util.report("Defaulting to no-operation (NOP) logger implementation");
//                    Util.report("See " + NO_STATICLOGGERBINDER_URL
//                            + " for further details.");
//                } else {
//                    failedBinding(ncde);
//                    throw ncde;
//                }
//            } catch (java.lang.NoSuchMethodError nsme) {
//                String msg = nsme.getMessage();
//                if (msg != null && msg.indexOf("org.slf4j.impl.StaticLoggerBinder.getSingleton()") != -1) {
//                    INITIALIZATION_STATE = FAILED_INITIALIZATION;
//                    Util.report("slf4j-api 1.6.x (or later) is incompatible with this binding.");
//                    Util.report("Your binding is version 1.5.5 or earlier.");
//                    Util.report("Upgrade your binding to version 1.6.x.");
//                }
//                throw nsme;
//            } catch (Exception e) {
//                failedBinding(e);
//                throw new IllegalStateException("Unexpected initialization failure", e);
//            }
//        }
    }
}
