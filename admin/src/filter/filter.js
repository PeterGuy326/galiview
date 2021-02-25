/**
 * 数组过滤器 例如：{{SECTION_CHARGE | optionKV(section.charge)}}
 * @param object 例如：{CHARGE:{key:"C", value:"收费"},FREE:{key:"F", value:"免费"}}
 * @param key 例如：C
 * @returns {string} 例如：收费
 */
let optionKV = (object, key) =>  {
    if (!object || !key) {
        return "";
    } else {
        let result = "";
        for(let enums in object){
            if (key === object[enums]["key"]) {
                result = object[enums]["value"];
            }
        }
        return result;
    }
};
/**
 * 数组过滤器 例如：{{CHARGE | optionKVArray(section.charge)}}
 * @param list 例如：[{key:"C", value:"收费"},{key:"F", value:"免费"}]
 * @param key 例如：C
 * @returns {string} 例如：收费
 */
let optionKVArray = (list, key) =>  {
    if (!list || !key) {
        return "";
    } else {
        let result = "";
        for (let i = 0; i < list.length; i++) {
            if (key === list[i]["key"]) {
                result = list[i]["value"];
            }
        }
        return result;
    }
};
export default {
    optionKV
}