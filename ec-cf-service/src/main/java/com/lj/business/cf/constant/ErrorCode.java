package com.lj.business.cf.constant;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */


/**
 * 类说明：会员错误代码定义类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author LeoPeng
 * 
 * 
 * CreateDate: 2017-5-28
 */
public class ErrorCode {
	
	/** 客户提醒JOB错误. */
	public static final String REMIND_JOB_ERROR = "remind_job_error";
	
	/** 销售冠军JOB错误. */
	public static final String XIAO_SHOU_JOB_ERROR = "xiao_shou_job_error";
	
	
	/** 新增跟进异常情况表信息错误. */
	public static final String CFERRORINFO_ADD_ERROR = "cferrorinfo_add_error";
	/** 编辑跟进异常情况表信息错误. */
	public static final String CFERRORINFO_EDIT_ERROR = "cferrorinfo_edit_error";
	/** 查找跟进异常情况表信息错误. */
	public static final String CFERRORINFO_FIND_ERROR = "cferrorinfo_find_error";
	/** 跟进异常情况表信息分页查询错误. */
	public static final String CFERRORINFO_FIND_PAGE_ERROR = "cferrorinfo_find_page_error";
	
	/** 新增工作任务表（社交）信息错误. */
	public static final String SOCIAL_TASK_ADD_ERROR = "social_task_add_error";
	/** 删除工作任务表（社交）信息错误. */
	public static final String SOCIAL_TASK_DEL_ERROR = "social_task_del_error";
	/** 工作任务表（社交）信息更新错误. */
	public static final String SOCIAL_TASK_UPDATE_ERROR = "social_task_update_error";
	/** 查找工作任务表（社交）信息错误. */
	public static final String SOCIAL_TASK_FIND_ERROR = "social_task_find_error";
	/** 统计工作任务表（社交）信息错误. */
	public static final String SOCIAL_TASK_FIND_ST_ERROR = "social_task_find_st_error";
	/** 工作任务表（社交）信息分页查询错误. */
	public static final String SOCIAL_TASK_FIND_PAGE_ERROR = "social_task_find_page_error";
	/** 工作任务表（社交）信息不存在错误. */
	public static final String SOCIAL_TASK_NOT_EXIST_ERROR = "social_task_not_exist_error";
	
	/** 新增工作事项选择表信息错误. */
	public static final String WORKTASKCHOOSE_ADD_ERROR = "worktaskchoose_add_error";
	/** 编辑工作事项选择表信息错误. */
	public static final String WORKTASKCHOOSE_EDIT_ERROR = "worktaskchoose_edit_error";
	/** 查找工作事项选择表信息错误. */
	public static final String WORKTASKCHOOSE_FIND_ERROR = "worktaskchoose_find_error";
	/** 删除工作事项选择表信息错误. */
	public static final String WORKTASKCHOOSE_DEL_ERROR = "worktaskchoose_del_error";
	/** 删除工作事项选择表信息分页查询错误. */
	public static final String WORKTASKCHOOSE_FIND_PAGE_ERROR = "worktaskchoose_find_page_error";
	
	/** 新增客户沟通任务事项表信息错误. */
	public static final String COMTASKCHOOSE_ADD_ERROR = "comtaskchoose_add_error";
	/** 编辑客户沟通任务事项表信息错误. */
	public static final String COMTASKCHOOSE_EDIT_ERROR = "comtaskchoose_edit_error";
	/** 查找客户沟通任务事项表信息错误. */
	public static final String COMTASKCHOOSE_FIND_ERROR = "comtaskchoose_find_error";
	/** 删除客户沟通任务事项表信息错误. */
	public static final String COMTASKCHOOSE_DEL_ERROR = "comtaskchoose_del_error";
	/** 客户沟通任务事项表信息分页查询错误. */
	public static final String COMTASKCHOOSE_FIND_PAGE_ERROR = "comtaskchoose_find_page_error";
	
	/** 新增客户沟通任务事项表信息错误. */
	public static final String COMTASKLIST_ADD_ERROR = "comtasklist_add_error";
	/** 编辑客户沟通任务事项表信息错误. */
	public static final String COMTASKLIST_EDIT_ERROR = "comtasklist_edit_error";
	/** 查找客户沟通任务事项表信息错误. */
	public static final String COMTASKLIST_FIND_ERROR = "comtasklist_find_error";
	/** 客户沟通任务事项表信息分页查询错误. */
	public static final String COMTASKLIST_FIND_PAGE_ERROR = "comtasklist_find_page_error";
	
	/** 新增店长任务设置表信息错误. */
	public static final String TASK_SET_ADD_ERROR = "task_set_add_error";
	/** 删除店长任务设置表信息错误. */
	public static final String TASK_SET_DEL_ERROR = "task_set_del_error";
	/** 店长任务设置表信息更新错误. */
	public static final String TASK_SET_UPDATE_ERROR = "task_set_update_error";
	/** 查找店长任务设置表信息错误. */
	public static final String TASK_SET_FIND_ERROR = "task_set_find_error";
	/** 店长任务设置表信息分页查询错误. */
	public static final String TASK_SET_FIND_PAGE_ERROR = "task_set_find_page_error";
	/** 店长任务设置表信息不存在. */
	public static final String TASK_SET_NOT_EXIST_ERROR = "task_set_not_exist_error";
	
	/** 新增店长待办事项列表信息错误. */
	public static final String TASK_SCH_SP_ADD_ERROR = "task_sch_sp_add_error";
	/** 删除店长待办事项列表信息错误. */
	public static final String TASK_SCH_SP_DEL_ERROR = "task_sch_sp_del_error";
	/** 店长待办事项列表信息更新错误. */
	public static final String TASK_SCH_SP_UPDATE_ERROR = "task_sch_sp_update_error";
	/** 查找店长待办事项列表信息错误. */
	public static final String TASK_SCH_SP_FIND_ERROR = "task_sch_sp_find_error";
	/** 店长待办事项列表信息分页查询错误. */
	public static final String TASK_SCH_SP_FIND_PAGE_ERROR = "task_sch_sp_find_page_error";
	/** 店长待办事项列表信息不存在. */
	public static final String TASK_SCH_SP_NOT_EXIST_ERROR = "task_sch_sp_not_exist_error";
	
	/** 新增未完成工作任务表信息错误. */
	public static final String WORK_TASK_UNFINISH_ADD_ERROR = "work_task_unfinish_add_error";
	/** 删除未完成工作任务表信息错误. */
	public static final String WORK_TASK_UNFINISH_DEL_ERROR = "work_task_unfinish_del_error";
	/** 未完成工作任务表信息更新错误. */
	public static final String WORK_TASK_UNFINISH_UPDATE_ERROR = "work_task_unfinish_update_error";
	/** 查找未完成工作任务表信息错误. */
	public static final String WORK_TASK_UNFINISH_FIND_ERROR = "work_task_unfinish_find_error";
	/** 未完成工作任务表信息分页查询错误. */
	public static final String WORK_TASK_UNFINISH_FIND_PAGE_ERROR = "work_task_unfinish_find_page_error";
	/** 未完成工作任务表信息不存在. */
	public static final String WORK_TASK_UNFINISH_NOT_EXIST_ERROR = "work_task_unfinish_not_exist_error";

	/** 新增工作事项分组表信息错误. */
	public static final String WORK_TASK_GROUP_ADD_ERROR = "work_task_group_add_error";
	/** 删除工作事项分组表信息错误. */
	public static final String WORK_TASK_GROUP_DEL_ERROR = "work_task_group_del_error";
	/** 工作事项分组表信息更新错误. */
	public static final String WORK_TASK_GROUP_UPDATE_ERROR = "work_task_group_update_error";
	/** 查找工作事项分组表信息错误. */
	public static final String WORK_TASK_GROUP_FIND_ERROR = "work_task_group_find_error";
	/** 工作事项分组表信息分页查询错误. */
	public static final String WORK_TASK_GROUP_FIND_PAGE_ERROR = "work_task_group_find_page_error";
	/** 工作事项分组表信息不存在. */
	public static final String WORK_TASK_GROUP_NOT_EXIST_ERROR = "work_task_group_not_exist_error";

	
	
	/** 新增工作事项表信息错误. */
	public static final String WORK_TASK_LIST_ADD_ERROR = "work_task_list_add_error";
	/** 删除工作事项表信息错误. */
	public static final String WORK_TASK_LIST_DEL_ERROR = "work_task_list_del_error";
	/** 工作事项表信息更新错误. */
	public static final String WORK_TASK_LIST_UPDATE_ERROR = "work_task_list_update_error";
	/** 查找工作事项表信息错误. */
	public static final String WORK_TASK_LIST_FIND_ERROR = "work_task_list_find_error";
	/** 工作事项表信息分页查询错误. */
	public static final String WORK_TASK_LIST_FIND_PAGE_ERROR = "work_task_list_find_page_error";
	/** 工作事项表信息不存在. */
	public static final String WORK_TASK_LIST_NOT_EXIST_ERROR = "work_task_list_not_exist_error";
	
	/** 新增工作任务统计表信息错误. */
	public static final String WORK_TASK_ADD_ERROR = "work_task_add_error";
	/** 删除工作任务统计表信息错误. */
	public static final String WORK_TASK_DEL_ERROR = "work_task_del_error";
	/** 工作任务统计表信息更新错误. */
	public static final String WORK_TASK_UPDATE_ERROR = "work_task_update_error";
	/** 查找工作任务统计表信息错误. */
	public static final String WORK_TASK_FIND_ERROR = "work_task_find_error";
	/** 工作任务统计表信息分页查询错误. */
	public static final String WORK_TASK_FIND_PAGE_ERROR = "work_task_find_page_error";
	/** 工作任务统计表信息不存在. */
	public static final String WORK_TASK_NOT_EXIST_ERROR = "work_task_not_exist_error";
	
	/** 新增客户维护记录表信息错误. */
	public static final String CLENT_KEEP_ADD_ERROR = "clent_keep_add_error";
	/** 删除客户维护记录表信息错误. */
	public static final String CLENT_KEEP_DEL_ERROR = "clent_keep_del_error";
	/** 客户维护记录表信息更新错误. */
	public static final String CLENT_KEEP_UPDATE_ERROR = "clent_keep_update_error";
	/** 查找客户维护记录表信息错误. */
	public static final String CLENT_KEEP_FIND_ERROR = "clent_keep_find_error";
	/** 客户维护记录表信息分页查询错误. */
	public static final String CLENT_KEEP_FIND_PAGE_ERROR = "clent_keep_find_page_error";
	/** 客户维护记录表信息不存在. */
	public static final String CLENT_KEEP_NOT_EXIST_ERROR = "clent_keep_not_exist_error";

	
	/** 新增客户跟踪表信息错误. */
	public static final String CLIENT_FOLLOW_ADD_ERROR = "client_follow_add_error";
	/** 删除客户跟踪表信息错误. */
	public static final String CLIENT_FOLLOW_DEL_ERROR = "client_follow_del_error";
	/** 客户跟踪表信息更新错误. */
	public static final String CLIENT_FOLLOW_UPDATE_ERROR = "client_follow_update_error";
	/** 查找客户跟踪表信息错误. */
	public static final String CLIENT_FOLLOW_FIND_ERROR = "client_follow_find_error";
	/** 客户跟踪表信息分页查询错误. */
	public static final String CLIENT_FOLLOW_FIND_PAGE_ERROR = "client_follow_find_page_error";
	/** 客户跟踪表信息不存在. */
	public static final String CLIENT_FOLLOW_NOT_EXIST_ERROR = "client_follow_not_exist_error";
	/** 跟进时间大于下次跟进时间  **/
	public static final String CLIENT_FOLLOW_DATE_ERROR = "client_follow_date_error";
	/** 跟进数据异常  **/
	public static final String CLIENT_FOLLOW_DATA_ERROR = "client_follow_data_error";
	/** 跟进数据异常通用  **/
	public static final String CLIENT_FOLLOW_DATA_COMMON_ERROR = "client_follow_data_common_error";
	/** 跟进数据异常时间  **/
	public static final String CLIENT_FOLLOW_DATA_TIME_LOW_ERROR = "client_follow_data_time_low_error";
	
	
	/** 维护时间大于下次跟进时间  **/
	public static final String CLIENT_KEEP_DATE_ERROR = "client_keep_date_error";
	/** 维护数据异常  **/
	public static final String CLIENT_KEEP_DATA_ERROR = "client_keep_data_error";
	/** 查找最后一条跟进记录  **/
	public static final String CLIENT_FOLLOW_LAST_ERROR = "client_follow_last_error";
	/** 查找最后一条维护记录  **/
	public static final String CLIENT_KEEP_LAST_ERROR = "client_keep_last_error";

	
	/** 新增客户放弃表信息错误. */
	public static final String PM_ABANDON_ADD_ERROR = "pm_abandon_add_error";
	/** 删除客户放弃表信息错误. */
	public static final String PM_ABANDON_DEL_ERROR = "pm_abandon_del_error";
	/** 客户放弃表信息更新错误. */
	public static final String PM_ABANDON_UPDATE_ERROR = "pm_abandon_update_error";
	/** 查找客户放弃表信息错误. */
	public static final String PM_ABANDON_FIND_ERROR = "pm_abandon_find_error";
	/** 客户放弃表信息分页查询错误. */
	public static final String PM_ABANDON_FIND_PAGE_ERROR = "pm_abandon_find_page_error";
	/** 客户放弃表信息不存在. */
	public static final String PM_ABANDON_NOT_EXIST_ERROR = "pm_abandon_not_exist_error";
	/** 客户放弃表审批错误. */
	public static final String PM_ABANDON_CHECK_ERROR = "pm_abandon_check_error";
	/** 修改未审批的放弃记录为拒绝. */
	public static final String PM_ABANDON_UPDATE_NOCHECK_ERROR = "pm_abandon_update_nocheck_error";
	/** 存在未审批的放弃记录  **/
	public static final String PM_ABANDON_NOCHECK_DATA_ERROR = "pm_abandon_nocheck_data_error";
	/** 客户放弃需要跟进10次以上. */
	public static final String PM_ABANDON_CHECK_TIME_ERROR = "pm_abandon_check_time_error";
	
	
	/** 新增店长待办事项列表信息错误. */
	public static final String TASK_SCH_SP_TYPE_ADD_ERROR = "task_sch_sp_type_add_error";
	/** 删除店长待办事项类型信息错误. */
	public static final String TASK_SCH_SP_TYPE_DEL_ERROR = "task_sch_sp_type_del_error";
	/** 店长待办事项类型信息更新错误. */
	public static final String TASK_SCH_SP_TYPE_UPDATE_ERROR = "task_sch_sp_type_update_error";
	/** 查找店长待办事项类型信息错误. */
	public static final String TASK_SCH_SP_TYPE_FIND_ERROR = "task_sch_sp_type_find_error";
	/** 店长待办事项类型信息分页查询错误. */
	public static final String TASK_SCH_SP_TYPE_FIND_PAGE_ERROR = "task_sch_sp_type_find_page_error";
	/** 店长待办事项类型信息不存在. */
	public static final String TASK_SCH_SP_TYPE_NOT_EXIST_ERROR = "task_sch_sp_type_not_exist_error";

	
	/** 新增客户沟通任务表信息错误. */
	public static final String COM_TASK_ADD_ERROR = "com_task_add_error";
	/** 删除客户沟通任务表信息错误. */
	public static final String COM_TASK_DEL_ERROR = "com_task_del_error";
	/** 客户沟通任务表信息更新错误. */
	public static final String COM_TASK_UPDATE_ERROR = "com_task_update_error";
	/** 查找客户沟通任务表信息错误. */
	public static final String COM_TASK_FIND_ERROR = "com_task_find_error";
	/** 客户沟通任务表信息分页查询错误. */
	public static final String COM_TASK_FIND_PAGE_ERROR = "com_task_find_page_error";
	/** 客户沟通任务表信息不存在. */
	public static final String COM_TASK_NOT_EXIST_ERROR = "com_task_not_exist_error";
	/** 业务任务时间计算错误. */
	public static final String COM_TASK_NEXT_DATE_ERROR = "com_task_next_date_error";
	

	/** 新增客户沟通任务流程表信息错误. */
	public static final String COM_TASK_WORKFLOW_ADD_ERROR = "com_task_workflow_add_error";
	/** 删除客户沟通任务流程表信息错误. */
	public static final String COM_TASK_WORKFLOW_DEL_ERROR = "com_task_workflow_del_error";
	/** 客户沟通任务流程表信息更新错误. */
	public static final String COM_TASK_WORKFLOW_UPDATE_ERROR = "com_task_workflow_update_error";
	/** 查找客户沟通任务流程表信息错误. */
	public static final String COM_TASK_WORKFLOW_FIND_ERROR = "com_task_workflow_find_error";
	/** 客户沟通任务流程表信息分页查询错误. */
	public static final String COM_TASK_WORKFLOW_FIND_PAGE_ERROR = "com_task_workflow_find_page_error";
	/** 客户沟通任务流程表信息不存在. */
	public static final String COM_TASK_WORKFLOW_NOT_EXIST_ERROR = "com_task_workflow_not_exist_error";
	
	
	/** 新增客户跟踪表信息错误. */
	public static final String CLIENT_FOLLOW_SUMMARY_ADD_ERROR = "client_follow_summary_add_error";
	/** 删除客户跟踪表信息错误. */
	public static final String CLIENT_FOLLOW_SUMMARY_DEL_ERROR = "client_follow_summary_del_error";
	/** 客户跟踪表信息更新错误. */
	public static final String CLIENT_FOLLOW_SUMMARY_UPDATE_ERROR = "client_follow_summary_update_error";
	/** 查找客户跟踪表信息错误. */
	public static final String CLIENT_FOLLOW_SUMMARY_FIND_ERROR = "client_follow_summary_find_error";
	/** 客户跟踪表信息分页查询错误. */
	public static final String CLIENT_FOLLOW_SUMMARY_FIND_PAGE_ERROR = "client_follow_summary_find_page_error";
	/** 客户跟踪表信息不存在. */
	public static final String CLIENT_FOLLOW_SUMMARY_NOT_EXIST_ERROR = "client_follow_summary_not_exist_error";
	/** 查询最后一次跟踪时间错误**/
	public static final String CLIENT_FOLLOW_SUMMARY_FIND_LAST_DATE_ERROR = "client_follow_summary_find_last_date_error";
	
	
	/** 新增客户维护记录总表信息错误. */
	public static final String CLIENT_KEEP_SUMMARY_ADD_ERROR = "client_keep_summary_add_error";
	/** 删除客户维护记录总表信息错误. */
	public static final String CLIENT_KEEP_SUMMARY_DEL_ERROR = "client_keep_summary_del_error";
	/** 客户维护记录总表信息更新错误. */
	public static final String CLIENT_KEEP_SUMMARY_UPDATE_ERROR = "client_keep_summary_update_error";
	/** 查找客户维护记录总表信息错误. */
	public static final String CLIENT_KEEP_SUMMARY_FIND_ERROR = "client_keep_summary_find_error";
	/** 客户维护记录总表信息分页查询错误. */
	public static final String CLIENT_KEEP_SUMMARY_FIND_PAGE_ERROR = "client_keep_summary_find_page_error";
	/** 客户维护记录总表信息不存在. */
	public static final String CLIENT_KEEP_SUMMARY_NOT_EXIST_ERROR = "client_keep_summary_not_exist_error";
	
	/** 跟进或者维护列表查询错误**/
	public static final String CLIENT_FOLLOW_KEEP_FIND_ERROR = "client_follow_keep_find_error";
	
	/** 查询今天订单错误**/
	public static final String CLIENT_FOLLOW_FIND_ORDER = "client_follow_find_order";
	
	/** 新增店长任务设置表信息信息错误. */
	public static final String TASK_SET_SHOP_ADD_ERROR = "task_set_shop_add_error";
	/** 删除店长任务设置表信息信息错误. */
	public static final String TASK_SET_SHOP_DEL_ERROR = "task_set_shop_del_error";
	/** 店长任务设置表信息信息更新错误. */
	public static final String TASK_SET_SHOP_UPDATE_ERROR = "task_set_shop_update_error";
	/** 查找店长任务设置表信息信息错误. */
	public static final String TASK_SET_SHOP_FIND_ERROR = "task_set_shop_find_error";
	/** 店长任务设置表信息信息分页查询错误. */
	public static final String TASK_SET_SHOP_FIND_PAGE_ERROR = "task_set_shop_find_page_error";
	/** 店长任务设置表信息信息不存在错误. */
	public static final String TASK_SET_SHOP_NOT_EXIST_ERROR = "task_set_shop_not_exist_error";
	
	
	/** 新增店长任务设置明细表信息错误. */
	public static final String TASK_SET_SHOP_DETAIL_ADD_ERROR = "task_set_shop_detail_add_error";
	/** 删除店长任务设置明细表信息错误. */
	public static final String TASK_SET_SHOP_DETAIL_DEL_ERROR = "task_set_shop_detail_del_error";
	/** 店长任务设置明细表信息更新错误. */
	public static final String TASK_SET_SHOP_DETAIL_UPDATE_ERROR = "task_set_shop_detail_update_error";
	/** 查找店长任务设置明细表信息错误. */
	public static final String TASK_SET_SHOP_DETAIL_FIND_ERROR = "task_set_shop_detail_find_error";
	/** 店长任务设置明细表信息分页查询错误. */
	public static final String TASK_SET_SHOP_DETAIL_FIND_PAGE_ERROR = "task_set_shop_detail_find_page_error";
	/** 店长任务设置明细表信息不存在错误. */
	public static final String TASK_SET_SHOP_DETAIL_NOT_EXIST_ERROR = "task_set_shop_detail_not_exist_error";
	/** 根据当前时间查找店长任务设置明细表信息错误. */
	public static final String TASK_SET_SHOP_DETAIL_FIND_BY_DAY_ERROR = "task_set_shop_detail_find_by_day_error";
	
	
	/** 新增其他任务完成情况表信息错误. */
	public static final String OTHER_TASK_FINISH_INFO_ADD_ERROR = "other_task_finish_info_add_error";
	/** 删除其他任务完成情况表信息错误. */
	public static final String OTHER_TASK_FINISH_INFO_DEL_ERROR = "other_task_finish_info_del_error";
	/** 其他任务完成情况表信息更新错误. */
	public static final String OTHER_TASK_FINISH_INFO_UPDATE_ERROR = "other_task_finish_info_update_error";
	/** 查找其他任务完成情况表信息错误. */
	public static final String OTHER_TASK_FINISH_INFO_FIND_ERROR = "other_task_finish_info_find_error";
	/** 其他任务完成情况表信息分页查询错误. */
	public static final String OTHER_TASK_FINISH_INFO_FIND_PAGE_ERROR = "other_task_finish_info_find_page_error";
	/** 其他任务完成情况表信息不存在错误. */
	public static final String OTHER_TASK_FINISH_INFO_NOT_EXIST_ERROR = "other_task_finish_info_not_exist_error";
	/** 查找其他任务完成情况表信息每日初始化错误. */
	public static final String OTHER_TASK_FINISH_INFO_DAY_FIND_ERROR = "other_task_finish_info_day_find_error";
	
	
	/** 新增其他任务完成情况表信息错误. */
	public static final String UNFINISH_TASK_SUMMARY_ADD_ERROR = "unfinish_task_summary_add_error";
	/** 删除其他任务完成情况表信息错误. */
	public static final String UNFINISH_TASK_SUMMARY_DEL_ERROR = "unfinish_task_summary_del_error";
	/** 其他任务完成情况表信息更新错误. */
	public static final String UNFINISH_TASK_SUMMARY_UPDATE_ERROR = "unfinish_task_summary_update_error";
	/** 查找其他任务完成情况表信息错误. */
	public static final String UNFINISH_TASK_SUMMARY_FIND_ERROR = "unfinish_task_summary_find_error";
	/** 其他任务完成情况表信息分页查询错误. */
	public static final String UNFINISH_TASK_SUMMARY_FIND_PAGE_ERROR = "unfinish_task_summary_find_page_error";
	/** 其他任务完成情况表信息不存在错误. */
	public static final String UNFINISH_TASK_SUMMARY_NOT_EXIST_ERROR = "unfinish_task_summary_not_exist_error";
	
	
	/** 新增客户引导记录表信息错误. */
	public static final String CLIENT_GUID_INFO_ADD_ERROR = "client_guid_info_add_error";
	/** 删除客户引导记录表信息错误. */
	public static final String CLIENT_GUID_INFO_DEL_ERROR = "client_guid_info_del_error";
	/** 客户引导记录表信息更新错误. */
	public static final String CLIENT_GUID_INFO_UPDATE_ERROR = "client_guid_info_update_error";
	/** 查找客户引导记录表信息错误. */
	public static final String CLIENT_GUID_INFO_FIND_ERROR = "client_guid_info_find_error";
	/** 客户引导记录表信息分页查询错误. */
	public static final String CLIENT_GUID_INFO_FIND_PAGE_ERROR = "client_guid_info_find_page_error";
	/** 客户引导记录表信息不存在错误. */
	public static final String CLIENT_GUID_INFO_NOT_EXIST_ERROR = "client_guid_info_not_exist_error";
	
	/** 新增客户邀约表信息错误. */
	public static final String CLIENT_INVITE_ADD_ERROR = "client_invite_add_error";
	/** 删除客户邀约表信息错误. */
	public static final String CLIENT_INVITE_DEL_ERROR = "client_invite_del_error";
	/** 客户邀约表信息更新错误. */
	public static final String CLIENT_INVITE_UPDATE_ERROR = "client_invite_update_error";
	/** 查找客户邀约表信息错误. */
	public static final String CLIENT_INVITE_FIND_ERROR = "client_invite_find_error";
	/** 客户邀约表信息分页查询错误. */
	public static final String CLIENT_INVITE_FIND_PAGE_ERROR = "client_invite_find_page_error";
	/** 客户邀约表信息不存在错误. */
	public static final String CLIENT_INVITE_NOT_EXIST_ERROR = "client_invite_not_exist_error";
	
	
	/** 提醒发送素材生成跟进记录错误. */
	public static final String CLIENT_FOLLOW_NOTICE_SENT_MET_ERROR = "client_follow_notice_sent_met_error";
	
	
}
