import opennlp.tools.langdetect.*

u = "http://apache.forsale.plus/opennlp/models/langdetect/1.8.3/langdetect-183.bin"
d = new LanguageDetectorME(new LanguageDetectorModel(new URL(u)))
a = 'Bienvenue à Paris'
b = 'Velkommen til København'

// meant to fail (French != Danish) to illustrate Groovy's power assert feature
assert d.predictLanguage(a).lang == d.predictLanguage(b).lang

/*

Assertion failed:

assert d.predictLanguage(a).lang == d.predictLanguage(b).lang
       | |               |  |    |  | |               |  |
       | |               |  'fra'|  | |               |  'dan'
       | |               |       |  | |               'Velkommen til København'
       | |               |       |  | dan (0.024727160814654276)
       | |               |       |  opennlp.tools.langdetect.LanguageDetectorME@184497d1
       | |               |       false
       | |               'Bienvenue à Paris'
       | fra (0.018630393459062138)
       opennlp.tools.langdetect.LanguageDetectorME@184497d1

*/
