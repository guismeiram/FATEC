let token = null;

export function setAuthToken(t) {
  token = t;
}

export function getAuthToken() {
  return token;
}

export function clearAuthToken() {
  token = null;
}