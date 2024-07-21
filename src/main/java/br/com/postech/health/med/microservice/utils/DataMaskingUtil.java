package br.com.postech.health.med.microservice.utils;


public class DataMaskingUtil {

  /**
   * Mascara dados sensíveis.
   *
   * @param data Os dados a serem mascarados.
   * @param showFirst Quantos caracteres mostrar no início.
   * @param showLast Quantos caracteres mostrar no final.
   * @return Uma string com os dados mascarados.
   */
  public static String maskSensitiveData(String data, int showFirst, int showLast) {
    if (data == null || data.length() <= showFirst + showLast) {
      return data;
    }

    int maskLength = data.length() - showFirst - showLast;
    StringBuilder maskedData = new StringBuilder(data.substring(0, showFirst));

    for (int i = 0; i < maskLength; i++) {
      maskedData.append("*");
    }

    maskedData.append(data.substring(data.length() - showLast));

    return maskedData.toString();
  }
}
