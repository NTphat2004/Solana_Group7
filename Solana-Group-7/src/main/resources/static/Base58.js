/**
 * Minified by jsDelivr using UglifyJS v3.1.10.
 * Original file: /npm/base-58@0.0.1/Base58.js
 * 
 * Do NOT use SRI with dynamically generated files! More information: https://www.jsdelivr.com/using-sri-with-dynamic-files
 */
(function(){var e,n,r,t;for(r=("undefined"!=typeof module&&null!==module?module.exports:void 0)||(window.Base58={}),e="123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz",n={},t=0;t<e.length;)n[e.charAt(t)]=t,t++;r.encode=function(n){var r,o,i;if(0===n.length)return"";for(t=void 0,i=void 0,o=[0],t=0;t<n.length;){for(i=0;i<o.length;)o[i]<<=8,i++;for(o[0]+=n[t],r=0,i=0;i<o.length;)o[i]+=r,r=o[i]/58|0,o[i]%=58,++i;for(;r;)o.push(r%58),r=r/58|0;t++}for(t=0;0===n[t]&&t<n.length-1;)o.push(0),t++;return o.reverse().map(function(n){return e[n]}).join("")},r.decode=function(e){var r,o,i,f;if(0===e.length)return new("undefined"!=typeof Uint8Array&&null!==Uint8Array?Uint8Array:Buffer)(0);for(t=void 0,f=void 0,r=[0],t=0;t<e.length;){if(!((o=e[t])in n))throw"Base58.decode received unacceptable input. Character '"+o+"' is not in the Base58 alphabet.";for(f=0;f<r.length;)r[f]*=58,f++;for(r[0]+=n[o],i=0,f=0;f<r.length;)r[f]+=i,i=r[f]>>8,r[f]&=255,++f;for(;i;)r.push(255&i),i>>=8;t++}for(t=0;"1"===e[t]&&t<e.length-1;)r.push(0),t++;return new("undefined"!=typeof Uint8Array&&null!==Uint8Array?Uint8Array:Buffer)(r.reverse())}}).call(this);
//# sourceMappingURL=/sm/00a434abdf400023dcf8f898cdf1d9995fc539cfb147f39857345f32ff3fb6c9.map/**
//  * Minified by jsDelivr using UglifyJS v3.1.10.
// * Original file: /npm/base-58@0.0.1/Base58.js
// * 
// * Do NOT use SRI with dynamically generated files! More information: https://www.jsdelivr.com/using-sri-with-dynamic-files
// */
(function(){var e,n,r,t;for(r=("undefined"!=typeof module&&null!==module?module.exports:void 0)||(window.Base58={}),e="123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz",n={},t=0;t<e.length;)n[e.charAt(t)]=t,t++;r.encode=function(n){var r,o,i;if(0===n.length)return"";for(t=void 0,i=void 0,o=[0],t=0;t<n.length;){for(i=0;i<o.length;)o[i]<<=8,i++;for(o[0]+=n[t],r=0,i=0;i<o.length;)o[i]+=r,r=o[i]/58|0,o[i]%=58,++i;for(;r;)o.push(r%58),r=r/58|0;t++}for(t=0;0===n[t]&&t<n.length-1;)o.push(0),t++;return o.reverse().map(function(n){return e[n]}).join("")},r.decode=function(e){var r,o,i,f;if(0===e.length)return new("undefined"!=typeof Uint8Array&&null!==Uint8Array?Uint8Array:Buffer)(0);for(t=void 0,f=void 0,r=[0],t=0;t<e.length;){if(!((o=e[t])in n))throw"Base58.decode received unacceptable input. Character '"+o+"' is not in the Base58 alphabet.";for(f=0;f<r.length;)r[f]*=58,f++;for(r[0]+=n[o],i=0,f=0;f<r.length;)r[f]+=i,i=r[f]>>8,r[f]&=255,++f;for(;i;)r.push(255&i),i>>=8;t++}for(t=0;"1"===e[t]&&t<e.length-1;)r.push(0),t++;return new("undefined"!=typeof Uint8Array&&null!==Uint8Array?Uint8Array:Buffer)(r.reverse())}}).call(this);
//# sourceMappingURL=/sm/00a434abdf400023dcf8f898cdf1d9995fc539cfb147f39857345f32ff3fb6c9.map