package com.cs4080.cppscheduleapi

enum class ClassSubject {
    ABM, ACC, AG, AGS, AH, AHS, AMM, ANT, ARC, ARO, AST, AVS, BIO, BUS, CE, CHE, CHM, CHN, CIS, CLS, CM, COM, CPU, CRM, CS, DAN, EBZ, EC, ECE, ECI, ECS, EDD, EDL, EDU, EGR, EMT, ENG, ENV, ERA, ETE, ETM, EWS, FRE, FRL, FST, GBA, GEO, GER, GSC, HRT, HST, IAM, IBM, IE, IGE, IME, INA, IPC, KIN, LA, LIB, LRC, LS, MAT, ME, MFE, MHR, MPA, MSL, MTE, MU, NTR, PHL, PHY, PLS, PLT, PSY, RS, SCI, SE, SME, SOC, SPN, STA, STS, SW, TH, TOM, URP, VCD
}

enum class CourseComponent(val value: String) {
    ACTIVITY("ACT"),
    CLINICAL("CLN"),
    INDEPENDENT_STUDY("IND"),
    LABORATORY("LAB"),
    LECTURE("LEC"),
    PRACTICUM("PRA"),
    SEMINAR("SEM"),
    SUPERVISION("SUP"),
    THESIS_RESEARCH("THE")
}

enum class CourseAttribute(val value: String) {
    ANY("Any Attribute"),                                    //Any Attribute
    AMP("ACP|NULL"),                                        //American Cultural Perspectives
    A("GE-A|NULL"),                                        //Area A-Eng Lang Com Crtcl Thnk
    A1("GE-A|A-1"),                                        //A-1 Oral Communication
    A2("GE-A|A-2"),                                        //A-2 Written Communication
    A3("GE-A|A-3"),                                        //A-3 Critical Thinking
    B("GE-B|NULL"),                                        //Area B-Sci Inquiry &amp; Quant Rsn
    B1("GE-B|B-1"),                                        //B-1 Physical Sciences
    B2("GE-B|B-2"),                                        //B-2 Life Sciences
    B3("GE-B|B-3"),                                        //B-3 Laboratory Activity
    B4("GE-B|B-4"),                                        //B-4 Math/Quant Reasoning
    B5("GE-B|B-5"),                                        //B-5 Science and Tech Synthesis
    C("GE-C|NULL"),                                        //Area C-Arts and Humanities
    C1("GE-C|C-1"),                                        //C-1 Visual &amp; Performing Arts
    C2("GE-C|C-2"),                                        //C-2 Lit, Mod Lng, Phl &amp; Cvlztn
    C3("GE-C|C-3"),                                        //C-3 Arts &amp; Humanities Synth
    D("GE-D|NULL"),                                        //Area D-Social Sciences
    D1("GE-D|D-1"),                                        //D-1 US History American Ideals
    D2("GE-D|D-2"),                                        //D-2 US Constitution &amp; CA Gvmnt
    D3("GE-D|D-3"),                                        //D-3 SocSci:Prn, Mthd, Val, Eth
    D4("GE-D|D-4"),                                        //D-4 Social Science Synthesis
    E("GE-E|NULL"),                                        //Area E-Lifelong Undst/Self Dev
    F("GE-F|NULL"),                                        //Area F-Ethnic Studies
    GRADUATE_DIVISION("CLEV|3"),                            //Course Level: Graduate Division
    LOWER_DIVISION("CLEV|1"),                                //Course Level: Lower Division
    UPPER_DIVISION("CLEV|2"),                                //Course Level: Upper Division
    ACTIVITY("CSFX|A"),                                    //Activity
    HONORS("CSFX|H"),                                        //Honors
    LABORATORY("CSFX|L"),                                    //Laboratory
    SERVICE_LEARNING("CSFX|S"),                            //Service Learning
    HONORS_ACTIVITY("CSFX|AH"),                            //Honors Activity
    HONORS_SERVICE_LEARNING_ACTIVITY("CSFX|AHS"),            //Honors Service Learning Act
    SERVICE_LEARNING_ACTIVITY("CSFX|AS"),                    //Service Learning Activity
    HONORS_SERVICE_LEARNING("CSFX|HS"),                    //Honors Service Learning
    HONORS_LABORATORY("CSFX|LH"),                            //Honors Laboratory
    HONORS_SERVICE_LEARNING_LABORATORY("CSFX|LHS"),        //Honors Service Learning Laboratory
    SERVICE_LEARNING_LABORATORY("CSFX|LS"),                //Service Learning Laboratory
    MULTILINGUAL("CSFX|M"),                                //Multilingual
    EXTRA_CREDIT_COMMUNITY_ENGLISH_LEARNING("CCEL|EC"),    //Extra Credit Cmty Eng Lrng
    OPTIONAL_COMMUNITY_ENGLISH_LEARNING("CCEL|O"),        //Optional Cmty Eng Lrng
    REQUIRED_COMMUNITY_ENGLISH_LEARNING("CCEL|R"),        //Required Cmty Eng Lrng
    EXTRA_CREDIT_SERVICE_LEARNING("CSLI|EC"),                //Extra Credit Service Learning
    OPTIONAL_SERVICE_LEARNING_COURSE("CSLI|O"),            //Optional Service Learning Crse
    REQUIRED_SERVICE_LEARNING_COURSE("CSLI|R"),            //Required Service Learning Crse
    EXTENDED_EDUCATION("CCTP|2"),                            //Extended Education
    UNIVERSITY_OPEN_UNIVERSITY("CCTP|1"),                    //University Open University
    ZERO_COST_COURSE_MATERIALS("ZCCM|ZCCM"),                //Zero Cost Course Materials
    ONLINE("FONL|AB386"),                                    //Online
    COURSE_MATCH("FONL|CM")                                //Course Match
}

enum class CourseCareer(val value: String) {
    ANY("Any Career"),
    NON_CREDIT_EXTENSION("EXED"),
    GRADUATE("GRAD"),
    GRADUATE_POSTBACCALAUREATE("PBAC"),
    UNDERGRADUATE("UGRD")

}

enum class InstructionMode(val value: String) {
    ANY_MODE("Any Mode"),
    ASYNCHRONOUS_LOCAL("AL"),
    FACE_TO_FACE("P"),
    FULLY_ASYNCHRONOUS("A"),
    FULLY_SYNCHRONOUS("S"),
    HYBRID("H"),
    HYBRID_ASYNCHRONOUS_COMPONENT("HA"),
    HYBRID_SYNCHRONOUS_COMPONENT("HS"),
    SYNCHRONOUS_LOCAL("SL"),
    WEB_ASSISTED("PW"),
    UNKNOWN("B") //todo
}

enum class CourseSession(val value: String) {
    ANY_SESSION("Any Session"),
    FIRST_3_WEEK_SESSION("OUT"),
    FIRST_TWO_WEEK_SESSION("OUA"),
    SECOND_3_WEEK_SESSION("OUU"),
    SECOND_TWO_WEEK_SESSION("OUB"),
    THIRD_TWO_WEEK_SESSION("OUC"),
    FOURTH_TWO_WEEK_SESSION("OUD"),
    ESP_10_WEEK_SESSION("OUE"),
    ESP_1ST_5_WEEK_SESSION("OUF"),
    ESP_2ND_5_WEEK_SESSION("OUG"),
    ESP_6_WEEK_SESSION("OUI"),
    ESP_8_WEEK_SESSION("OUH"),
    EXTENSION_SESSION("EXT"),
    EXTENSION_SESSION_1ST_5WK("EX1"),
    FIVE_WEEK_FIRST("5W1"),
    FIVE_WEEK_SECOND("5W2"),
    OPEN_UNIVERSITY_1ST_5WK("OU1"),
    OPEN_UNIVERSITY_2ND_5WK("OU2"),
    OPEN_UNIVERSITY_QUARTER_SB("OUQ"),
    PEN_UNIVERSITY_SESSION("OU"),
    OPEN_UNIVERSITY_SUM09("OUS"),
    RGULAR_ACADEMIC_SESSION("1"),
    SIX_WEEK_SECOND("6W2"),
    SPECIAL_SESSION_FIRST_5_WEEKS("SP1"),
    SPECIAL_SESSION_SECOND_5_WEEKS("SP2"),
    SPECIAL_SESSION_DEGREE("SPD"),
    SPECIAL_SESSION_QUARTER("QTR"),
    SPECIAL_SESSION_QUARTER_WINTER("QTW"),
    UNKNOWN("OUS")
}

enum class CourseTime(val value: String) {
    ONE_AM("01:00:00 AM"),
    TWO_AM("02:00:00 AM"),
    THREE_AM("03:00:00 AM"),
    FOUR_AM("04:00:00 AM"),
    FIVE_AM("05:00:00 AM"),
    SIX_AM("06:00:00 AM"),
    SEVEN_AM("07:00:00 AM"),
    EIGHT_AM("08:00:00 AM"),
    NINE_AM("09:00:00 AM"),
    TEN_AM("10:00:00 AM"),
    ELEVEN_AM("11:00:00 AM"),
    TWELVE_PM("12:00:00 PM"),
    ONE_PM("01:00:00 PM"),
    TWO_PM("02:00:00 PM"),
    THREE_PM("03:00:00 PM"),
    FOUR_PM("04:00:00 PM"),
    FIVE_PM("05:00:00 PM"),
    SIX_PM("06:00:00 PM"),
    SEVEN_PM("07:00:00 PM"),
    EIGHT_PM("08:00:00 PM"),
    NINE_PM("09:00:00 PM"),
    TEN_PM("10:00:00 PM"),
    ELEVEN_PM("11:00:00 PM"),
    TWELVE_AM("12:00:00 AM"),
}

enum class ClassDays(val value: String) {
    MONDAY("0"),
    TUESDAY("1"),
    WEDNESDAY("2"),
    THURSDAY("3"),
    FRIDAY("4"),
    SATURDAY("5"),
    SUNDAY("6"),
    TBA("7")
}

fun buildSearchParams(
    term: String? = null,
    subject: ClassSubject? = null,
    catalogNumber: String? = null,
    subjectExactMatch: Boolean? = null,
    title: String? = null,
    courseComponent: CourseComponent? = null,
    courseAttribute: CourseAttribute? = null,
    courseCareer: CourseCareer? = null,
    instructionMode: InstructionMode? = null,
    courseSession: CourseSession? = null,
    possibleDays: Array<ClassDays>? = null,
    startTime: CourseTime? = null,
    endTime: CourseTime? = null,
    instructor: String? = null
): HashMap<String, String> {
    var params = HashMap<String, String>()
    params["ctl00_ContentPlaceHolder1_TermDDL"] = term ?: "2217"
    params["ctl00_ContentPlaceHolder1_ClassSubject"] = subject?.name ?: "cs"
    params["ctl00_ContentPlaceHolder1_CatalogNumber"] = catalogNumber ?: ""
    if (subjectExactMatch == true) {
        params["ctl00_ContentPlaceHolder1_CatalogNumberCHK"] = "on"
    }
    params["ctl00_ContentPlaceHolder1_Description"] = title ?: ""
    params["ctl00_ContentPlaceHolder1_CourseComponentDDL"] = courseComponent?.value ?: "Any Component"
    params["ctl00_ContentPlaceHolder1_CourseAttributeDDL"] = courseAttribute?.value ?: "Any Attribute"
    params["ctl00_ContentPlaceHolder1_CourseCareerDDL"] = courseCareer?.value ?: "Any Career"
    params["ctl00_ContentPlaceHolder1_InstModesDDL"] = instructionMode?.value ?: "Any Mode"
    params["ctl00_ContentPlaceHolder1_SessionDDL"] = courseSession?.value ?: "Any Session"
    if (possibleDays == null) {
        for (i in 0..7)
            params["ctl00_ContentPlaceHolder1_ClassDays_".plus(i)] = "on"
    } else {
        for (day in possibleDays)
            params["ctl00_ContentPlaceHolder1_ClassDays_".plus(day.value)] = "on"
    }
    params["ctl00_ContentPlaceHolder1_StartTime"] = startTime?.value ?: "ANY"
    params["ctl00_ContentPlaceHolder1_EndTime"] = endTime?.value ?: "ANY"
    params["ctl00_ContentPlaceHolder1_Instructor"] = instructor ?: ""

    return params
}

fun convertTerm(term: String?): String {
    var value = 2187;
    if (term == null) return value.toString();

    if (term[0].equals('f', true)) {
        value += 10 * (term.substring(1..2).toInt() - 18);
    } else if (term.substring(0..1).equals("Sp", true)) {
        value += 10 * (term.substring(2..3).toInt() - 18) - 4;
    } else if (term.substring(0..1).equals("su", true)) {
        value += 10 * (term.substring(2..3).toInt() - 18) - 6;
    }

    return value.toString();
}