package com.prios.ws.services.util;

import java.security.Principal;

import javax.ejb.SessionContext;

import com.prios.ws.helper.UserWSRole;
import com.prios.ws.services.demo.fault.AuthentificationFaultException;

public class UtilisateurUtil {

	public static boolean estConnuAvecDroitLecture(SessionContext sessionContext)
			throws AuthentificationFaultException {
		if (sessionContext != null) {
			if (sessionContext.getCallerPrincipal() != null) {
				Principal p  = sessionContext.getCallerPrincipal();
				System.out.println(p.getName());
				if (!sessionContext.isCallerInRole(UserWSRole.CONSULT.getRole())) {
					throw new AuthentificationFaultException("L'utilisateur doit être identifié et avoir le rôle adéquat");
				}
				return true;
			} else {
				throw new AuthentificationFaultException("L'utilisateur doit être identifié et connu de l'annuaire");
			}
		}
		return false;
	}

	public static boolean estConnuAvecDroitEcriture(SessionContext sessionContext)
			throws AuthentificationFaultException {
		if (sessionContext != null) {
			if (sessionContext.getCallerPrincipal() != null) {
				if (!sessionContext.isCallerInRole(UserWSRole.ECRITURE.getRole())) {
					throw new AuthentificationFaultException("L'utilisateur doit être identifié et avoir le rôle adéquat");
				}
				return true;
			} else {
				throw new AuthentificationFaultException("L'utilisateur doit être identifié et connu de l'annuaire");
			}
		}
		return false;
	}
}
