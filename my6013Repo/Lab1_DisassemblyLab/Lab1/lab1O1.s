	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 12, 0	sdk_version 12, 3
	.file	1 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include" "_stdio.h"
	.file	2 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include/arm" "_types.h"
	.file	3 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include/sys" "_types.h"
	.file	4 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include/c++/v1" "cstdio"
	.file	5 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include/sys/_types" "_size_t.h"
	.file	6 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include" "stdio.h"
	.file	7 "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include/sys/_types" "_va_list.h"
	.globl	__Z3addii                       ; -- Begin function _Z3addii
	.p2align	2
__Z3addii:                              ; @_Z3addii
Lfunc_begin0:
	.file	8 "/Users/jinny/MSD/myGithubRepo/my6013Repo/Lab1_DisassemblyLab/Lab1" "lab1.cpp"
	.loc	8 3 0                           ; lab1.cpp:3:0
	.cfi_startproc
; %bb.0:
	;DEBUG_VALUE: add:a <- $w0
	;DEBUG_VALUE: add:b <- $w1
	.loc	8 4 11 prologue_end             ; lab1.cpp:4:11
	add	w0, w1, w0
Ltmp0:
	;DEBUG_VALUE: add:a <- [DW_OP_LLVM_entry_value 1] $w0
	.loc	8 4 3 is_stmt 0                 ; lab1.cpp:4:3
	ret
Ltmp1:
Lfunc_end0:
	.cfi_endproc
                                        ; -- End function
	.globl	_main                           ; -- Begin function main
	.p2align	2
_main:                                  ; @main
Lfunc_begin1:
	.loc	8 7 0 is_stmt 1                 ; lab1.cpp:7:0
	.cfi_startproc
; %bb.0:
	sub	sp, sp, #32
	stp	x29, x30, [sp, #16]             ; 16-byte Folded Spill
	add	x29, sp, #16
	.cfi_def_cfa w29, 16
	.cfi_offset w30, -8
	.cfi_offset w29, -16
	mov	w8, #4
Ltmp2:
	.loc	8 8 3 prologue_end              ; lab1.cpp:8:3
	str	x8, [sp]
Lloh0:
	adrp	x0, l_.str@PAGE
Lloh1:
	add	x0, x0, l_.str@PAGEOFF
	bl	_printf
Ltmp3:
	.loc	8 9 3                           ; lab1.cpp:9:3
	mov	w0, #0
	ldp	x29, x30, [sp, #16]             ; 16-byte Folded Reload
	add	sp, sp, #32
	ret
Ltmp4:
	.loh AdrpAdd	Lloh0, Lloh1
Lfunc_end1:
	.cfi_endproc
                                        ; -- End function
	.section	__TEXT,__cstring,cstring_literals
l_.str:                                 ; @.str
	.asciz	"%d"

	.section	__DWARF,__debug_loc,regular,debug
Lsection_debug_loc:
Ldebug_loc0:
.set Lset0, Lfunc_begin0-Lfunc_begin0
	.quad	Lset0
.set Lset1, Ltmp0-Lfunc_begin0
	.quad	Lset1
	.short	1                               ; Loc expr size
	.byte	80                              ; DW_OP_reg0
.set Lset2, Ltmp0-Lfunc_begin0
	.quad	Lset2
.set Lset3, Lfunc_end0-Lfunc_begin0
	.quad	Lset3
	.short	4                               ; Loc expr size
	.byte	163                             ; DW_OP_entry_value
	.byte	1                               ; 1
	.byte	80                              ; DW_OP_reg0
	.byte	159                             ; DW_OP_stack_value
	.quad	0
	.quad	0
	.section	__DWARF,__debug_abbrev,regular,debug
Lsection_abbrev:
	.byte	1                               ; Abbreviation Code
	.byte	17                              ; DW_TAG_compile_unit
	.byte	1                               ; DW_CHILDREN_yes
	.byte	37                              ; DW_AT_producer
	.byte	14                              ; DW_FORM_strp
	.byte	19                              ; DW_AT_language
	.byte	5                               ; DW_FORM_data2
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.ascii	"\202|"                         ; DW_AT_LLVM_sysroot
	.byte	14                              ; DW_FORM_strp
	.ascii	"\357\177"                      ; DW_AT_APPLE_sdk
	.byte	14                              ; DW_FORM_strp
	.byte	16                              ; DW_AT_stmt_list
	.byte	23                              ; DW_FORM_sec_offset
	.byte	27                              ; DW_AT_comp_dir
	.byte	14                              ; DW_FORM_strp
	.ascii	"\341\177"                      ; DW_AT_APPLE_optimized
	.byte	25                              ; DW_FORM_flag_present
	.byte	17                              ; DW_AT_low_pc
	.byte	1                               ; DW_FORM_addr
	.byte	18                              ; DW_AT_high_pc
	.byte	6                               ; DW_FORM_data4
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	2                               ; Abbreviation Code
	.byte	57                              ; DW_TAG_namespace
	.byte	1                               ; DW_CHILDREN_yes
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	3                               ; Abbreviation Code
	.byte	57                              ; DW_TAG_namespace
	.byte	1                               ; DW_CHILDREN_yes
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.ascii	"\211\001"                      ; DW_AT_export_symbols
	.byte	25                              ; DW_FORM_flag_present
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	4                               ; Abbreviation Code
	.byte	8                               ; DW_TAG_imported_declaration
	.byte	0                               ; DW_CHILDREN_no
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	24                              ; DW_AT_import
	.byte	19                              ; DW_FORM_ref4
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	5                               ; Abbreviation Code
	.byte	22                              ; DW_TAG_typedef
	.byte	0                               ; DW_CHILDREN_no
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	6                               ; Abbreviation Code
	.byte	19                              ; DW_TAG_structure_type
	.byte	1                               ; DW_CHILDREN_yes
	.byte	54                              ; DW_AT_calling_convention
	.byte	11                              ; DW_FORM_data1
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	11                              ; DW_AT_byte_size
	.byte	11                              ; DW_FORM_data1
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	7                               ; Abbreviation Code
	.byte	13                              ; DW_TAG_member
	.byte	0                               ; DW_CHILDREN_no
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	56                              ; DW_AT_data_member_location
	.byte	11                              ; DW_FORM_data1
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	8                               ; Abbreviation Code
	.byte	15                              ; DW_TAG_pointer_type
	.byte	0                               ; DW_CHILDREN_no
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	9                               ; Abbreviation Code
	.byte	36                              ; DW_TAG_base_type
	.byte	0                               ; DW_CHILDREN_no
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	62                              ; DW_AT_encoding
	.byte	11                              ; DW_FORM_data1
	.byte	11                              ; DW_AT_byte_size
	.byte	11                              ; DW_FORM_data1
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	10                              ; Abbreviation Code
	.byte	15                              ; DW_TAG_pointer_type
	.byte	0                               ; DW_CHILDREN_no
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	11                              ; Abbreviation Code
	.byte	21                              ; DW_TAG_subroutine_type
	.byte	1                               ; DW_CHILDREN_yes
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	12                              ; Abbreviation Code
	.byte	5                               ; DW_TAG_formal_parameter
	.byte	0                               ; DW_CHILDREN_no
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	13                              ; Abbreviation Code
	.byte	38                              ; DW_TAG_const_type
	.byte	0                               ; DW_CHILDREN_no
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	14                              ; Abbreviation Code
	.byte	19                              ; DW_TAG_structure_type
	.byte	0                               ; DW_CHILDREN_no
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	60                              ; DW_AT_declaration
	.byte	25                              ; DW_FORM_flag_present
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	15                              ; Abbreviation Code
	.byte	1                               ; DW_TAG_array_type
	.byte	1                               ; DW_CHILDREN_yes
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	16                              ; Abbreviation Code
	.byte	33                              ; DW_TAG_subrange_type
	.byte	0                               ; DW_CHILDREN_no
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	55                              ; DW_AT_count
	.byte	11                              ; DW_FORM_data1
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	17                              ; Abbreviation Code
	.byte	36                              ; DW_TAG_base_type
	.byte	0                               ; DW_CHILDREN_no
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	11                              ; DW_AT_byte_size
	.byte	11                              ; DW_FORM_data1
	.byte	62                              ; DW_AT_encoding
	.byte	11                              ; DW_FORM_data1
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	18                              ; Abbreviation Code
	.byte	46                              ; DW_TAG_subprogram
	.byte	1                               ; DW_CHILDREN_yes
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	60                              ; DW_AT_declaration
	.byte	25                              ; DW_FORM_flag_present
	.byte	63                              ; DW_AT_external
	.byte	25                              ; DW_FORM_flag_present
	.ascii	"\341\177"                      ; DW_AT_APPLE_optimized
	.byte	25                              ; DW_FORM_flag_present
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	19                              ; Abbreviation Code
	.byte	46                              ; DW_TAG_subprogram
	.byte	1                               ; DW_CHILDREN_yes
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	60                              ; DW_AT_declaration
	.byte	25                              ; DW_FORM_flag_present
	.byte	63                              ; DW_AT_external
	.byte	25                              ; DW_FORM_flag_present
	.ascii	"\341\177"                      ; DW_AT_APPLE_optimized
	.byte	25                              ; DW_FORM_flag_present
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	20                              ; Abbreviation Code
	.byte	24                              ; DW_TAG_unspecified_parameters
	.byte	0                               ; DW_CHILDREN_no
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	21                              ; Abbreviation Code
	.byte	46                              ; DW_TAG_subprogram
	.byte	1                               ; DW_CHILDREN_yes
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	5                               ; DW_FORM_data2
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	60                              ; DW_AT_declaration
	.byte	25                              ; DW_FORM_flag_present
	.byte	63                              ; DW_AT_external
	.byte	25                              ; DW_FORM_flag_present
	.ascii	"\341\177"                      ; DW_AT_APPLE_optimized
	.byte	25                              ; DW_FORM_flag_present
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	22                              ; Abbreviation Code
	.byte	22                              ; DW_TAG_typedef
	.byte	0                               ; DW_CHILDREN_no
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	23                              ; Abbreviation Code
	.byte	46                              ; DW_TAG_subprogram
	.byte	1                               ; DW_CHILDREN_yes
	.byte	110                             ; DW_AT_linkage_name
	.byte	14                              ; DW_FORM_strp
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	60                              ; DW_AT_declaration
	.byte	25                              ; DW_FORM_flag_present
	.byte	63                              ; DW_AT_external
	.byte	25                              ; DW_FORM_flag_present
	.ascii	"\341\177"                      ; DW_AT_APPLE_optimized
	.byte	25                              ; DW_FORM_flag_present
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	24                              ; Abbreviation Code
	.byte	38                              ; DW_TAG_const_type
	.byte	0                               ; DW_CHILDREN_no
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	25                              ; Abbreviation Code
	.byte	46                              ; DW_TAG_subprogram
	.byte	0                               ; DW_CHILDREN_no
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	60                              ; DW_AT_declaration
	.byte	25                              ; DW_FORM_flag_present
	.byte	63                              ; DW_AT_external
	.byte	25                              ; DW_FORM_flag_present
	.ascii	"\341\177"                      ; DW_AT_APPLE_optimized
	.byte	25                              ; DW_FORM_flag_present
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	26                              ; Abbreviation Code
	.byte	46                              ; DW_TAG_subprogram
	.byte	1                               ; DW_CHILDREN_yes
	.byte	17                              ; DW_AT_low_pc
	.byte	1                               ; DW_FORM_addr
	.byte	18                              ; DW_AT_high_pc
	.byte	6                               ; DW_FORM_data4
	.ascii	"\347\177"                      ; DW_AT_APPLE_omit_frame_ptr
	.byte	25                              ; DW_FORM_flag_present
	.byte	64                              ; DW_AT_frame_base
	.byte	24                              ; DW_FORM_exprloc
	.byte	122                             ; DW_AT_call_all_calls
	.byte	25                              ; DW_FORM_flag_present
	.byte	110                             ; DW_AT_linkage_name
	.byte	14                              ; DW_FORM_strp
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	63                              ; DW_AT_external
	.byte	25                              ; DW_FORM_flag_present
	.ascii	"\341\177"                      ; DW_AT_APPLE_optimized
	.byte	25                              ; DW_FORM_flag_present
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	27                              ; Abbreviation Code
	.byte	5                               ; DW_TAG_formal_parameter
	.byte	0                               ; DW_CHILDREN_no
	.byte	2                               ; DW_AT_location
	.byte	23                              ; DW_FORM_sec_offset
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	28                              ; Abbreviation Code
	.byte	5                               ; DW_TAG_formal_parameter
	.byte	0                               ; DW_CHILDREN_no
	.byte	2                               ; DW_AT_location
	.byte	24                              ; DW_FORM_exprloc
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	29                              ; Abbreviation Code
	.byte	46                              ; DW_TAG_subprogram
	.byte	0                               ; DW_CHILDREN_no
	.byte	17                              ; DW_AT_low_pc
	.byte	1                               ; DW_FORM_addr
	.byte	18                              ; DW_AT_high_pc
	.byte	6                               ; DW_FORM_data4
	.byte	64                              ; DW_AT_frame_base
	.byte	24                              ; DW_FORM_exprloc
	.byte	122                             ; DW_AT_call_all_calls
	.byte	25                              ; DW_FORM_flag_present
	.byte	3                               ; DW_AT_name
	.byte	14                              ; DW_FORM_strp
	.byte	58                              ; DW_AT_decl_file
	.byte	11                              ; DW_FORM_data1
	.byte	59                              ; DW_AT_decl_line
	.byte	11                              ; DW_FORM_data1
	.byte	73                              ; DW_AT_type
	.byte	19                              ; DW_FORM_ref4
	.byte	63                              ; DW_AT_external
	.byte	25                              ; DW_FORM_flag_present
	.ascii	"\341\177"                      ; DW_AT_APPLE_optimized
	.byte	25                              ; DW_FORM_flag_present
	.byte	0                               ; EOM(1)
	.byte	0                               ; EOM(2)
	.byte	0                               ; EOM(3)
	.section	__DWARF,__debug_info,regular,debug
Lsection_info:
Lcu_begin0:
.set Lset4, Ldebug_info_end0-Ldebug_info_start0 ; Length of Unit
	.long	Lset4
Ldebug_info_start0:
	.short	4                               ; DWARF version number
.set Lset5, Lsection_abbrev-Lsection_abbrev ; Offset Into Abbrev. Section
	.long	Lset5
	.byte	8                               ; Address Size (in bytes)
	.byte	1                               ; Abbrev [1] 0xb:0x827 DW_TAG_compile_unit
	.long	0                               ; DW_AT_producer
	.short	4                               ; DW_AT_language
	.long	49                              ; DW_AT_name
	.long	58                              ; DW_AT_LLVM_sysroot
	.long	153                             ; DW_AT_APPLE_sdk
.set Lset6, Lline_table_start0-Lsection_line ; DW_AT_stmt_list
	.long	Lset6
	.long	164                             ; DW_AT_comp_dir
                                        ; DW_AT_APPLE_optimized
	.quad	Lfunc_begin0                    ; DW_AT_low_pc
.set Lset7, Lfunc_end1-Lfunc_begin0     ; DW_AT_high_pc
	.long	Lset7
	.byte	2                               ; Abbrev [2] 0x32:0x163 DW_TAG_namespace
	.long	230                             ; DW_AT_name
	.byte	3                               ; Abbrev [3] 0x37:0x15d DW_TAG_namespace
	.long	234                             ; DW_AT_name
                                        ; DW_AT_export_symbols
	.byte	4                               ; Abbrev [4] 0x3c:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	107                             ; DW_AT_decl_line
	.long	405                             ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x43:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	108                             ; DW_AT_decl_line
	.long	807                             ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x4a:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	109                             ; DW_AT_decl_line
	.long	924                             ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x51:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	111                             ; DW_AT_decl_line
	.long	953                             ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x58:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	112                             ; DW_AT_decl_line
	.long	975                             ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x5f:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	113                             ; DW_AT_decl_line
	.long	992                             ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x66:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	114                             ; DW_AT_decl_line
	.long	1010                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x6d:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	115                             ; DW_AT_decl_line
	.long	1042                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x74:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	116                             ; DW_AT_decl_line
	.long	1065                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x7b:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	117                             ; DW_AT_decl_line
	.long	1088                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x82:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	118                             ; DW_AT_decl_line
	.long	1117                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x89:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	119                             ; DW_AT_decl_line
	.long	1140                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x90:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	120                             ; DW_AT_decl_line
	.long	1163                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x97:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	121                             ; DW_AT_decl_line
	.long	1221                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x9e:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	122                             ; DW_AT_decl_line
	.long	1249                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xa5:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	123                             ; DW_AT_decl_line
	.long	1277                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xac:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	124                             ; DW_AT_decl_line
	.long	1310                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xb3:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	125                             ; DW_AT_decl_line
	.long	1337                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xba:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	126                             ; DW_AT_decl_line
	.long	1354                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xc1:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	127                             ; DW_AT_decl_line
	.long	1381                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xc8:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	128                             ; DW_AT_decl_line
	.long	1403                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xcf:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	129                             ; DW_AT_decl_line
	.long	1429                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xd6:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	130                             ; DW_AT_decl_line
	.long	1446                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xdd:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	131                             ; DW_AT_decl_line
	.long	1468                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xe4:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	132                             ; DW_AT_decl_line
	.long	1490                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xeb:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	133                             ; DW_AT_decl_line
	.long	1522                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xf2:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	135                             ; DW_AT_decl_line
	.long	1564                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0xf9:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	137                             ; DW_AT_decl_line
	.long	1591                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x100:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	139                             ; DW_AT_decl_line
	.long	1625                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x107:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	141                             ; DW_AT_decl_line
	.long	1657                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x10e:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	142                             ; DW_AT_decl_line
	.long	1674                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x115:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	143                             ; DW_AT_decl_line
	.long	1687                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x11c:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	144                             ; DW_AT_decl_line
	.long	1700                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x123:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	145                             ; DW_AT_decl_line
	.long	1717                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x12a:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	146                             ; DW_AT_decl_line
	.long	1734                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x131:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	149                             ; DW_AT_decl_line
	.long	1747                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x138:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	150                             ; DW_AT_decl_line
	.long	1773                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x13f:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	152                             ; DW_AT_decl_line
	.long	1804                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x146:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	154                             ; DW_AT_decl_line
	.long	1821                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x14d:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	155                             ; DW_AT_decl_line
	.long	1843                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x154:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	156                             ; DW_AT_decl_line
	.long	1854                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x15b:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	160                             ; DW_AT_decl_line
	.long	1871                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x162:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	162                             ; DW_AT_decl_line
	.long	1882                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x169:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	164                             ; DW_AT_decl_line
	.long	1899                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x170:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	165                             ; DW_AT_decl_line
	.long	1917                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x177:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	169                             ; DW_AT_decl_line
	.long	1940                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x17e:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	170                             ; DW_AT_decl_line
	.long	1958                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x185:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	171                             ; DW_AT_decl_line
	.long	1975                            ; DW_AT_import
	.byte	4                               ; Abbrev [4] 0x18c:0x7 DW_TAG_imported_declaration
	.byte	4                               ; DW_AT_decl_file
	.byte	172                             ; DW_AT_decl_line
	.long	1992                            ; DW_AT_import
	.byte	0                               ; End Of Children Mark
	.byte	0                               ; End Of Children Mark
	.byte	5                               ; Abbrev [5] 0x195:0xb DW_TAG_typedef
	.long	416                             ; DW_AT_type
	.long	238                             ; DW_AT_name
	.byte	1                               ; DW_AT_decl_file
	.byte	157                             ; DW_AT_decl_line
	.byte	6                               ; Abbrev [6] 0x1a0:0xfa DW_TAG_structure_type
	.byte	5                               ; DW_AT_calling_convention
	.long	243                             ; DW_AT_name
	.byte	152                             ; DW_AT_byte_size
	.byte	1                               ; DW_AT_decl_file
	.byte	126                             ; DW_AT_decl_line
	.byte	7                               ; Abbrev [7] 0x1a9:0xc DW_TAG_member
	.long	251                             ; DW_AT_name
	.long	666                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	127                             ; DW_AT_decl_line
	.byte	0                               ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x1b5:0xc DW_TAG_member
	.long	268                             ; DW_AT_name
	.long	678                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	128                             ; DW_AT_decl_line
	.byte	8                               ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x1c1:0xc DW_TAG_member
	.long	275                             ; DW_AT_name
	.long	678                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	129                             ; DW_AT_decl_line
	.byte	12                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x1cd:0xc DW_TAG_member
	.long	278                             ; DW_AT_name
	.long	685                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	130                             ; DW_AT_decl_line
	.byte	16                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x1d9:0xc DW_TAG_member
	.long	291                             ; DW_AT_name
	.long	685                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	131                             ; DW_AT_decl_line
	.byte	18                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x1e5:0xc DW_TAG_member
	.long	297                             ; DW_AT_name
	.long	692                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	132                             ; DW_AT_decl_line
	.byte	24                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x1f1:0xc DW_TAG_member
	.long	320                             ; DW_AT_name
	.long	678                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	133                             ; DW_AT_decl_line
	.byte	40                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x1fd:0xc DW_TAG_member
	.long	329                             ; DW_AT_name
	.long	726                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	136                             ; DW_AT_decl_line
	.byte	48                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x209:0xc DW_TAG_member
	.long	337                             ; DW_AT_name
	.long	727                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	137                             ; DW_AT_decl_line
	.byte	56                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x215:0xc DW_TAG_member
	.long	344                             ; DW_AT_name
	.long	743                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	138                             ; DW_AT_decl_line
	.byte	64                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x221:0xc DW_TAG_member
	.long	355                             ; DW_AT_name
	.long	781                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	139                             ; DW_AT_decl_line
	.byte	72                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x22d:0xc DW_TAG_member
	.long	407                             ; DW_AT_name
	.long	847                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	140                             ; DW_AT_decl_line
	.byte	80                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x239:0xc DW_TAG_member
	.long	414                             ; DW_AT_name
	.long	692                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	143                             ; DW_AT_decl_line
	.byte	88                              ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x245:0xc DW_TAG_member
	.long	418                             ; DW_AT_name
	.long	883                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	144                             ; DW_AT_decl_line
	.byte	104                             ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x251:0xc DW_TAG_member
	.long	434                             ; DW_AT_name
	.long	678                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	145                             ; DW_AT_decl_line
	.byte	112                             ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x25d:0xc DW_TAG_member
	.long	438                             ; DW_AT_name
	.long	893                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	148                             ; DW_AT_decl_line
	.byte	116                             ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x269:0xc DW_TAG_member
	.long	464                             ; DW_AT_name
	.long	912                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	149                             ; DW_AT_decl_line
	.byte	119                             ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x275:0xc DW_TAG_member
	.long	470                             ; DW_AT_name
	.long	692                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	152                             ; DW_AT_decl_line
	.byte	120                             ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x281:0xc DW_TAG_member
	.long	474                             ; DW_AT_name
	.long	678                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	155                             ; DW_AT_decl_line
	.byte	136                             ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x28d:0xc DW_TAG_member
	.long	483                             ; DW_AT_name
	.long	807                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	156                             ; DW_AT_decl_line
	.byte	144                             ; DW_AT_data_member_location
	.byte	0                               ; End Of Children Mark
	.byte	8                               ; Abbrev [8] 0x29a:0x5 DW_TAG_pointer_type
	.long	671                             ; DW_AT_type
	.byte	9                               ; Abbrev [9] 0x29f:0x7 DW_TAG_base_type
	.long	254                             ; DW_AT_name
	.byte	8                               ; DW_AT_encoding
	.byte	1                               ; DW_AT_byte_size
	.byte	9                               ; Abbrev [9] 0x2a6:0x7 DW_TAG_base_type
	.long	271                             ; DW_AT_name
	.byte	5                               ; DW_AT_encoding
	.byte	4                               ; DW_AT_byte_size
	.byte	9                               ; Abbrev [9] 0x2ad:0x7 DW_TAG_base_type
	.long	285                             ; DW_AT_name
	.byte	5                               ; DW_AT_encoding
	.byte	2                               ; DW_AT_byte_size
	.byte	6                               ; Abbrev [6] 0x2b4:0x22 DW_TAG_structure_type
	.byte	5                               ; DW_AT_calling_convention
	.long	301                             ; DW_AT_name
	.byte	16                              ; DW_AT_byte_size
	.byte	1                               ; DW_AT_decl_file
	.byte	92                              ; DW_AT_decl_line
	.byte	7                               ; Abbrev [7] 0x2bd:0xc DW_TAG_member
	.long	308                             ; DW_AT_name
	.long	666                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	93                              ; DW_AT_decl_line
	.byte	0                               ; DW_AT_data_member_location
	.byte	7                               ; Abbrev [7] 0x2c9:0xc DW_TAG_member
	.long	314                             ; DW_AT_name
	.long	678                             ; DW_AT_type
	.byte	1                               ; DW_AT_decl_file
	.byte	94                              ; DW_AT_decl_line
	.byte	8                               ; DW_AT_data_member_location
	.byte	0                               ; End Of Children Mark
	.byte	10                              ; Abbrev [10] 0x2d6:0x1 DW_TAG_pointer_type
	.byte	8                               ; Abbrev [8] 0x2d7:0x5 DW_TAG_pointer_type
	.long	732                             ; DW_AT_type
	.byte	11                              ; Abbrev [11] 0x2dc:0xb DW_TAG_subroutine_type
	.long	678                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x2e1:0x5 DW_TAG_formal_parameter
	.long	726                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	8                               ; Abbrev [8] 0x2e7:0x5 DW_TAG_pointer_type
	.long	748                             ; DW_AT_type
	.byte	11                              ; Abbrev [11] 0x2ec:0x15 DW_TAG_subroutine_type
	.long	678                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x2f1:0x5 DW_TAG_formal_parameter
	.long	726                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x2f6:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x2fb:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	8                               ; Abbrev [8] 0x301:0x5 DW_TAG_pointer_type
	.long	774                             ; DW_AT_type
	.byte	9                               ; Abbrev [9] 0x306:0x7 DW_TAG_base_type
	.long	350                             ; DW_AT_name
	.byte	6                               ; DW_AT_encoding
	.byte	1                               ; DW_AT_byte_size
	.byte	8                               ; Abbrev [8] 0x30d:0x5 DW_TAG_pointer_type
	.long	786                             ; DW_AT_type
	.byte	11                              ; Abbrev [11] 0x312:0x15 DW_TAG_subroutine_type
	.long	807                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x317:0x5 DW_TAG_formal_parameter
	.long	726                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x31c:0x5 DW_TAG_formal_parameter
	.long	807                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x321:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	5                               ; Abbrev [5] 0x327:0xb DW_TAG_typedef
	.long	818                             ; DW_AT_type
	.long	361                             ; DW_AT_name
	.byte	1                               ; DW_AT_decl_file
	.byte	81                              ; DW_AT_decl_line
	.byte	5                               ; Abbrev [5] 0x332:0xb DW_TAG_typedef
	.long	829                             ; DW_AT_type
	.long	368                             ; DW_AT_name
	.byte	3                               ; DW_AT_decl_file
	.byte	71                              ; DW_AT_decl_line
	.byte	5                               ; Abbrev [5] 0x33d:0xb DW_TAG_typedef
	.long	840                             ; DW_AT_type
	.long	383                             ; DW_AT_name
	.byte	2                               ; DW_AT_decl_file
	.byte	24                              ; DW_AT_decl_line
	.byte	9                               ; Abbrev [9] 0x348:0x7 DW_TAG_base_type
	.long	393                             ; DW_AT_name
	.byte	5                               ; DW_AT_encoding
	.byte	8                               ; DW_AT_byte_size
	.byte	8                               ; Abbrev [8] 0x34f:0x5 DW_TAG_pointer_type
	.long	852                             ; DW_AT_type
	.byte	11                              ; Abbrev [11] 0x354:0x15 DW_TAG_subroutine_type
	.long	678                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x359:0x5 DW_TAG_formal_parameter
	.long	726                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x35e:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x363:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	8                               ; Abbrev [8] 0x369:0x5 DW_TAG_pointer_type
	.long	878                             ; DW_AT_type
	.byte	13                              ; Abbrev [13] 0x36e:0x5 DW_TAG_const_type
	.long	774                             ; DW_AT_type
	.byte	8                               ; Abbrev [8] 0x373:0x5 DW_TAG_pointer_type
	.long	888                             ; DW_AT_type
	.byte	14                              ; Abbrev [14] 0x378:0x5 DW_TAG_structure_type
	.long	425                             ; DW_AT_name
                                        ; DW_AT_declaration
	.byte	15                              ; Abbrev [15] 0x37d:0xc DW_TAG_array_type
	.long	671                             ; DW_AT_type
	.byte	16                              ; Abbrev [16] 0x382:0x6 DW_TAG_subrange_type
	.long	905                             ; DW_AT_type
	.byte	3                               ; DW_AT_count
	.byte	0                               ; End Of Children Mark
	.byte	17                              ; Abbrev [17] 0x389:0x7 DW_TAG_base_type
	.long	444                             ; DW_AT_name
	.byte	8                               ; DW_AT_byte_size
	.byte	7                               ; DW_AT_encoding
	.byte	15                              ; Abbrev [15] 0x390:0xc DW_TAG_array_type
	.long	671                             ; DW_AT_type
	.byte	16                              ; Abbrev [16] 0x395:0x6 DW_TAG_subrange_type
	.long	905                             ; DW_AT_type
	.byte	1                               ; DW_AT_count
	.byte	0                               ; End Of Children Mark
	.byte	5                               ; Abbrev [5] 0x39c:0xb DW_TAG_typedef
	.long	935                             ; DW_AT_type
	.long	491                             ; DW_AT_name
	.byte	5                               ; DW_AT_decl_file
	.byte	31                              ; DW_AT_decl_line
	.byte	5                               ; Abbrev [5] 0x3a7:0xb DW_TAG_typedef
	.long	946                             ; DW_AT_type
	.long	498                             ; DW_AT_name
	.byte	2                               ; DW_AT_decl_file
	.byte	70                              ; DW_AT_decl_line
	.byte	9                               ; Abbrev [9] 0x3b2:0x7 DW_TAG_base_type
	.long	514                             ; DW_AT_name
	.byte	7                               ; DW_AT_encoding
	.byte	8                               ; DW_AT_byte_size
	.byte	18                              ; Abbrev [18] 0x3b9:0x11 DW_TAG_subprogram
	.long	532                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	143                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x3c4:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	8                               ; Abbrev [8] 0x3ca:0x5 DW_TAG_pointer_type
	.long	405                             ; DW_AT_type
	.byte	18                              ; Abbrev [18] 0x3cf:0x11 DW_TAG_subprogram
	.long	539                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	146                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x3da:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	19                              ; Abbrev [19] 0x3e0:0x12 DW_TAG_subprogram
	.long	546                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	178                             ; DW_AT_decl_line
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x3e7:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x3ec:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x3f2:0x20 DW_TAG_subprogram
	.long	553                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	179                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x3fd:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x402:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x407:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x40c:0x5 DW_TAG_formal_parameter
	.long	924                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x412:0x17 DW_TAG_subprogram
	.long	561                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	155                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x41d:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x422:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	20                              ; Abbrev [20] 0x427:0x1 DW_TAG_unspecified_parameters
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x429:0x17 DW_TAG_subprogram
	.long	569                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	161                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x434:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x439:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	20                              ; Abbrev [20] 0x43e:0x1 DW_TAG_unspecified_parameters
	.byte	0                               ; End Of Children Mark
	.byte	21                              ; Abbrev [21] 0x440:0x1d DW_TAG_subprogram
	.long	576                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.short	327                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x44c:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x451:0x5 DW_TAG_formal_parameter
	.long	924                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x456:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	20                              ; Abbrev [20] 0x45b:0x1 DW_TAG_unspecified_parameters
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x45d:0x17 DW_TAG_subprogram
	.long	585                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	180                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x468:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x46d:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	20                              ; Abbrev [20] 0x472:0x1 DW_TAG_unspecified_parameters
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x474:0x17 DW_TAG_subprogram
	.long	593                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	181                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x47f:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x484:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	20                              ; Abbrev [20] 0x489:0x1 DW_TAG_unspecified_parameters
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x48b:0x1b DW_TAG_subprogram
	.long	600                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	190                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x496:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x49b:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x4a0:0x5 DW_TAG_formal_parameter
	.long	1190                            ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	5                               ; Abbrev [5] 0x4a6:0xb DW_TAG_typedef
	.long	1201                            ; DW_AT_type
	.long	609                             ; DW_AT_name
	.byte	7                               ; DW_AT_decl_file
	.byte	32                              ; DW_AT_decl_line
	.byte	5                               ; Abbrev [5] 0x4b1:0xb DW_TAG_typedef
	.long	1212                            ; DW_AT_type
	.long	617                             ; DW_AT_name
	.byte	2                               ; DW_AT_decl_file
	.byte	76                              ; DW_AT_decl_line
	.byte	22                              ; Abbrev [22] 0x4bc:0x9 DW_TAG_typedef
	.long	769                             ; DW_AT_type
	.long	634                             ; DW_AT_name
	.byte	21                              ; Abbrev [21] 0x4c5:0x1c DW_TAG_subprogram
	.long	652                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.short	328                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x4d1:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x4d6:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x4db:0x5 DW_TAG_formal_parameter
	.long	1190                            ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	21                              ; Abbrev [21] 0x4e1:0x1c DW_TAG_subprogram
	.long	660                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.short	331                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x4ed:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x4f2:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x4f7:0x5 DW_TAG_formal_parameter
	.long	1190                            ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	21                              ; Abbrev [21] 0x4fd:0x21 DW_TAG_subprogram
	.long	668                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.short	330                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x509:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x50e:0x5 DW_TAG_formal_parameter
	.long	924                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x513:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x518:0x5 DW_TAG_formal_parameter
	.long	1190                            ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x51e:0x1b DW_TAG_subprogram
	.long	678                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	192                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x529:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x52e:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x533:0x5 DW_TAG_formal_parameter
	.long	1190                            ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x539:0x11 DW_TAG_subprogram
	.long	687                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	147                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x544:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x54a:0x1b DW_TAG_subprogram
	.long	693                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	149                             ; DW_AT_decl_line
	.long	769                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x555:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x55a:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x55f:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x565:0x16 DW_TAG_subprogram
	.long	699                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	156                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x570:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x575:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	23                              ; Abbrev [23] 0x57b:0x1a DW_TAG_subprogram
	.long	705                             ; DW_AT_linkage_name
	.long	712                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	157                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x58a:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x58f:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x595:0x11 DW_TAG_subprogram
	.long	718                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	166                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x5a0:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x5a6:0x16 DW_TAG_subprogram
	.long	723                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	171                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x5b1:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x5b6:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x5bc:0x16 DW_TAG_subprogram
	.long	728                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	189                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x5c7:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x5cc:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x5d2:0x20 DW_TAG_subprogram
	.long	735                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	158                             ; DW_AT_decl_line
	.long	924                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x5dd:0x5 DW_TAG_formal_parameter
	.long	726                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x5e2:0x5 DW_TAG_formal_parameter
	.long	924                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x5e7:0x5 DW_TAG_formal_parameter
	.long	924                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x5ec:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	23                              ; Abbrev [23] 0x5f2:0x24 DW_TAG_subprogram
	.long	741                             ; DW_AT_linkage_name
	.long	749                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	165                             ; DW_AT_decl_line
	.long	924                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x601:0x5 DW_TAG_formal_parameter
	.long	1558                            ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x606:0x5 DW_TAG_formal_parameter
	.long	924                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x60b:0x5 DW_TAG_formal_parameter
	.long	924                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x610:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	8                               ; Abbrev [8] 0x616:0x5 DW_TAG_pointer_type
	.long	1563                            ; DW_AT_type
	.byte	24                              ; Abbrev [24] 0x61b:0x1 DW_TAG_const_type
	.byte	18                              ; Abbrev [18] 0x61c:0x16 DW_TAG_subprogram
	.long	756                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	148                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x627:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x62c:0x5 DW_TAG_formal_parameter
	.long	1586                            ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	8                               ; Abbrev [8] 0x632:0x5 DW_TAG_pointer_type
	.long	807                             ; DW_AT_type
	.byte	18                              ; Abbrev [18] 0x637:0x1b DW_TAG_subprogram
	.long	764                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	162                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x642:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x647:0x5 DW_TAG_formal_parameter
	.long	1618                            ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x64c:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	9                               ; Abbrev [9] 0x652:0x7 DW_TAG_base_type
	.long	770                             ; DW_AT_name
	.byte	5                               ; DW_AT_encoding
	.byte	8                               ; DW_AT_byte_size
	.byte	18                              ; Abbrev [18] 0x659:0x16 DW_TAG_subprogram
	.long	779                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	163                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x664:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x669:0x5 DW_TAG_formal_parameter
	.long	1647                            ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	8                               ; Abbrev [8] 0x66f:0x5 DW_TAG_pointer_type
	.long	1652                            ; DW_AT_type
	.byte	13                              ; Abbrev [13] 0x674:0x5 DW_TAG_const_type
	.long	807                             ; DW_AT_type
	.byte	18                              ; Abbrev [18] 0x679:0x11 DW_TAG_subprogram
	.long	787                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	164                             ; DW_AT_decl_line
	.long	1618                            ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x684:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	19                              ; Abbrev [19] 0x68a:0xd DW_TAG_subprogram
	.long	793                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	176                             ; DW_AT_decl_line
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x691:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	19                              ; Abbrev [19] 0x697:0xd DW_TAG_subprogram
	.long	800                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	142                             ; DW_AT_decl_line
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x69e:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x6a4:0x11 DW_TAG_subprogram
	.long	809                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	144                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x6af:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x6b5:0x11 DW_TAG_subprogram
	.long	814                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	145                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x6c0:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	19                              ; Abbrev [19] 0x6c6:0xd DW_TAG_subprogram
	.long	821                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	169                             ; DW_AT_decl_line
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x6cd:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	23                              ; Abbrev [23] 0x6d3:0x1a DW_TAG_subprogram
	.long	828                             ; DW_AT_linkage_name
	.long	835                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	153                             ; DW_AT_decl_line
	.long	970                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x6e2:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x6e7:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	23                              ; Abbrev [23] 0x6ed:0x1f DW_TAG_subprogram
	.long	841                             ; DW_AT_linkage_name
	.long	850                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	159                             ; DW_AT_decl_line
	.long	970                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x6fc:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x701:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x706:0x5 DW_TAG_formal_parameter
	.long	970                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x70c:0x11 DW_TAG_subprogram
	.long	858                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	174                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x717:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x71d:0x16 DW_TAG_subprogram
	.long	865                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	175                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x728:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x72d:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	25                              ; Abbrev [25] 0x733:0xb DW_TAG_subprogram
	.long	872                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	182                             ; DW_AT_decl_line
	.long	970                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	18                              ; Abbrev [18] 0x73e:0x11 DW_TAG_subprogram
	.long	880                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	188                             ; DW_AT_decl_line
	.long	769                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x749:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	25                              ; Abbrev [25] 0x74f:0xb DW_TAG_subprogram
	.long	887                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	167                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	18                              ; Abbrev [18] 0x75a:0x11 DW_TAG_subprogram
	.long	895                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	168                             ; DW_AT_decl_line
	.long	769                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x765:0x5 DW_TAG_formal_parameter
	.long	769                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x76b:0x12 DW_TAG_subprogram
	.long	900                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	177                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x776:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	20                              ; Abbrev [20] 0x77b:0x1 DW_TAG_unspecified_parameters
	.byte	0                               ; End Of Children Mark
	.byte	21                              ; Abbrev [21] 0x77d:0x17 DW_TAG_subprogram
	.long	906                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.short	329                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x789:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x78e:0x5 DW_TAG_formal_parameter
	.long	1190                            ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x794:0x12 DW_TAG_subprogram
	.long	913                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	170                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x79f:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	20                              ; Abbrev [20] 0x7a4:0x1 DW_TAG_unspecified_parameters
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x7a6:0x11 DW_TAG_subprogram
	.long	920                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	172                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x7b1:0x5 DW_TAG_formal_parameter
	.long	678                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x7b7:0x11 DW_TAG_subprogram
	.long	928                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	173                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x7c2:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	18                              ; Abbrev [18] 0x7c8:0x16 DW_TAG_subprogram
	.long	933                             ; DW_AT_name
	.byte	6                               ; DW_AT_decl_file
	.byte	191                             ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_declaration
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	12                              ; Abbrev [12] 0x7d3:0x5 DW_TAG_formal_parameter
	.long	873                             ; DW_AT_type
	.byte	12                              ; Abbrev [12] 0x7d8:0x5 DW_TAG_formal_parameter
	.long	1190                            ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	26                              ; Abbrev [26] 0x7de:0x3a DW_TAG_subprogram
	.quad	Lfunc_begin0                    ; DW_AT_low_pc
.set Lset8, Lfunc_end0-Lfunc_begin0     ; DW_AT_high_pc
	.long	Lset8
                                        ; DW_AT_APPLE_omit_frame_ptr
	.byte	1                               ; DW_AT_frame_base
	.byte	111
                                        ; DW_AT_call_all_calls
	.long	945                             ; DW_AT_linkage_name
	.long	941                             ; DW_AT_name
	.byte	8                               ; DW_AT_decl_file
	.byte	3                               ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	27                              ; Abbrev [27] 0x7fb:0xf DW_TAG_formal_parameter
.set Lset9, Ldebug_loc0-Lsection_debug_loc ; DW_AT_location
	.long	Lset9
	.long	959                             ; DW_AT_name
	.byte	8                               ; DW_AT_decl_file
	.byte	3                               ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
	.byte	28                              ; Abbrev [28] 0x80a:0xd DW_TAG_formal_parameter
	.byte	1                               ; DW_AT_location
	.byte	81
	.long	961                             ; DW_AT_name
	.byte	8                               ; DW_AT_decl_file
	.byte	3                               ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
	.byte	0                               ; End Of Children Mark
	.byte	29                              ; Abbrev [29] 0x818:0x19 DW_TAG_subprogram
	.quad	Lfunc_begin1                    ; DW_AT_low_pc
.set Lset10, Lfunc_end1-Lfunc_begin1    ; DW_AT_high_pc
	.long	Lset10
	.byte	1                               ; DW_AT_frame_base
	.byte	109
                                        ; DW_AT_call_all_calls
	.long	954                             ; DW_AT_name
	.byte	8                               ; DW_AT_decl_file
	.byte	7                               ; DW_AT_decl_line
	.long	678                             ; DW_AT_type
                                        ; DW_AT_external
                                        ; DW_AT_APPLE_optimized
	.byte	0                               ; End Of Children Mark
Ldebug_info_end0:
	.section	__DWARF,__debug_str,regular,debug
Linfo_string:
	.asciz	"Apple clang version 13.1.6 (clang-1316.0.21.2.5)" ; string offset=0
	.asciz	"lab1.cpp"                      ; string offset=49
	.asciz	"/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk" ; string offset=58
	.asciz	"MacOSX.sdk"                    ; string offset=153
	.asciz	"/Users/jinny/MSD/myGithubRepo/my6013Repo/Lab1_DisassemblyLab/Lab1" ; string offset=164
	.asciz	"std"                           ; string offset=230
	.asciz	"__1"                           ; string offset=234
	.asciz	"FILE"                          ; string offset=238
	.asciz	"__sFILE"                       ; string offset=243
	.asciz	"_p"                            ; string offset=251
	.asciz	"unsigned char"                 ; string offset=254
	.asciz	"_r"                            ; string offset=268
	.asciz	"int"                           ; string offset=271
	.asciz	"_w"                            ; string offset=275
	.asciz	"_flags"                        ; string offset=278
	.asciz	"short"                         ; string offset=285
	.asciz	"_file"                         ; string offset=291
	.asciz	"_bf"                           ; string offset=297
	.asciz	"__sbuf"                        ; string offset=301
	.asciz	"_base"                         ; string offset=308
	.asciz	"_size"                         ; string offset=314
	.asciz	"_lbfsize"                      ; string offset=320
	.asciz	"_cookie"                       ; string offset=329
	.asciz	"_close"                        ; string offset=337
	.asciz	"_read"                         ; string offset=344
	.asciz	"char"                          ; string offset=350
	.asciz	"_seek"                         ; string offset=355
	.asciz	"fpos_t"                        ; string offset=361
	.asciz	"__darwin_off_t"                ; string offset=368
	.asciz	"__int64_t"                     ; string offset=383
	.asciz	"long long int"                 ; string offset=393
	.asciz	"_write"                        ; string offset=407
	.asciz	"_ub"                           ; string offset=414
	.asciz	"_extra"                        ; string offset=418
	.asciz	"__sFILEX"                      ; string offset=425
	.asciz	"_ur"                           ; string offset=434
	.asciz	"_ubuf"                         ; string offset=438
	.asciz	"__ARRAY_SIZE_TYPE__"           ; string offset=444
	.asciz	"_nbuf"                         ; string offset=464
	.asciz	"_lb"                           ; string offset=470
	.asciz	"_blksize"                      ; string offset=474
	.asciz	"_offset"                       ; string offset=483
	.asciz	"size_t"                        ; string offset=491
	.asciz	"__darwin_size_t"               ; string offset=498
	.asciz	"long unsigned int"             ; string offset=514
	.asciz	"fclose"                        ; string offset=532
	.asciz	"fflush"                        ; string offset=539
	.asciz	"setbuf"                        ; string offset=546
	.asciz	"setvbuf"                       ; string offset=553
	.asciz	"fprintf"                       ; string offset=561
	.asciz	"fscanf"                        ; string offset=569
	.asciz	"snprintf"                      ; string offset=576
	.asciz	"sprintf"                       ; string offset=585
	.asciz	"sscanf"                        ; string offset=593
	.asciz	"vfprintf"                      ; string offset=600
	.asciz	"va_list"                       ; string offset=609
	.asciz	"__darwin_va_list"              ; string offset=617
	.asciz	"__builtin_va_list"             ; string offset=634
	.asciz	"vfscanf"                       ; string offset=652
	.asciz	"vsscanf"                       ; string offset=660
	.asciz	"vsnprintf"                     ; string offset=668
	.asciz	"vsprintf"                      ; string offset=678
	.asciz	"fgetc"                         ; string offset=687
	.asciz	"fgets"                         ; string offset=693
	.asciz	"fputc"                         ; string offset=699
	.asciz	"_fputs"                        ; string offset=705
	.asciz	"fputs"                         ; string offset=712
	.asciz	"getc"                          ; string offset=718
	.asciz	"putc"                          ; string offset=723
	.asciz	"ungetc"                        ; string offset=728
	.asciz	"fread"                         ; string offset=735
	.asciz	"_fwrite"                       ; string offset=741
	.asciz	"fwrite"                        ; string offset=749
	.asciz	"fgetpos"                       ; string offset=756
	.asciz	"fseek"                         ; string offset=764
	.asciz	"long int"                      ; string offset=770
	.asciz	"fsetpos"                       ; string offset=779
	.asciz	"ftell"                         ; string offset=787
	.asciz	"rewind"                        ; string offset=793
	.asciz	"clearerr"                      ; string offset=800
	.asciz	"feof"                          ; string offset=809
	.asciz	"ferror"                        ; string offset=814
	.asciz	"perror"                        ; string offset=821
	.asciz	"_fopen"                        ; string offset=828
	.asciz	"fopen"                         ; string offset=835
	.asciz	"_freopen"                      ; string offset=841
	.asciz	"freopen"                       ; string offset=850
	.asciz	"remove"                        ; string offset=858
	.asciz	"rename"                        ; string offset=865
	.asciz	"tmpfile"                       ; string offset=872
	.asciz	"tmpnam"                        ; string offset=880
	.asciz	"getchar"                       ; string offset=887
	.asciz	"gets"                          ; string offset=895
	.asciz	"scanf"                         ; string offset=900
	.asciz	"vscanf"                        ; string offset=906
	.asciz	"printf"                        ; string offset=913
	.asciz	"putchar"                       ; string offset=920
	.asciz	"puts"                          ; string offset=928
	.asciz	"vprintf"                       ; string offset=933
	.asciz	"add"                           ; string offset=941
	.asciz	"_Z3addii"                      ; string offset=945
	.asciz	"main"                          ; string offset=954
	.asciz	"a"                             ; string offset=959
	.asciz	"b"                             ; string offset=961
	.section	__DWARF,__apple_names,regular,debug
Lnames_begin:
	.long	1212240712                      ; Header Magic
	.short	1                               ; Header Version
	.short	0                               ; Header Hash Function
	.long	3                               ; Header Bucket Count
	.long	3                               ; Header Hash Count
	.long	12                              ; Header Data Length
	.long	0                               ; HeaderData Die Offset Base
	.long	1                               ; HeaderData Atom Count
	.short	1                               ; DW_ATOM_die_offset
	.short	6                               ; DW_FORM_data4
	.long	-1                              ; Bucket 0
	.long	0                               ; Bucket 1
	.long	2                               ; Bucket 2
	.long	193486030                       ; Hash in Bucket 1
	.long	2090499946                      ; Hash in Bucket 1
	.long	-1239051380                     ; Hash in Bucket 2
.set Lset11, LNames2-Lnames_begin       ; Offset in Bucket 1
	.long	Lset11
.set Lset12, LNames0-Lnames_begin       ; Offset in Bucket 1
	.long	Lset12
.set Lset13, LNames1-Lnames_begin       ; Offset in Bucket 2
	.long	Lset13
LNames2:
	.long	941                             ; add
	.long	1                               ; Num DIEs
	.long	2014
	.long	0
LNames0:
	.long	954                             ; main
	.long	1                               ; Num DIEs
	.long	2072
	.long	0
LNames1:
	.long	945                             ; _Z3addii
	.long	1                               ; Num DIEs
	.long	2014
	.long	0
	.section	__DWARF,__apple_objc,regular,debug
Lobjc_begin:
	.long	1212240712                      ; Header Magic
	.short	1                               ; Header Version
	.short	0                               ; Header Hash Function
	.long	1                               ; Header Bucket Count
	.long	0                               ; Header Hash Count
	.long	12                              ; Header Data Length
	.long	0                               ; HeaderData Die Offset Base
	.long	1                               ; HeaderData Atom Count
	.short	1                               ; DW_ATOM_die_offset
	.short	6                               ; DW_FORM_data4
	.long	-1                              ; Bucket 0
	.section	__DWARF,__apple_namespac,regular,debug
Lnamespac_begin:
	.long	1212240712                      ; Header Magic
	.short	1                               ; Header Version
	.short	0                               ; Header Hash Function
	.long	2                               ; Header Bucket Count
	.long	2                               ; Header Hash Count
	.long	12                              ; Header Data Length
	.long	0                               ; HeaderData Die Offset Base
	.long	1                               ; HeaderData Atom Count
	.short	1                               ; DW_ATOM_die_offset
	.short	6                               ; DW_FORM_data4
	.long	0                               ; Bucket 0
	.long	-1                              ; Bucket 1
	.long	193483636                       ; Hash in Bucket 0
	.long	193506160                       ; Hash in Bucket 0
.set Lset14, Lnamespac1-Lnamespac_begin ; Offset in Bucket 0
	.long	Lset14
.set Lset15, Lnamespac0-Lnamespac_begin ; Offset in Bucket 0
	.long	Lset15
Lnamespac1:
	.long	234                             ; __1
	.long	1                               ; Num DIEs
	.long	55
	.long	0
Lnamespac0:
	.long	230                             ; std
	.long	1                               ; Num DIEs
	.long	50
	.long	0
	.section	__DWARF,__apple_types,regular,debug
Ltypes_begin:
	.long	1212240712                      ; Header Magic
	.short	1                               ; Header Version
	.short	0                               ; Header Hash Function
	.long	9                               ; Header Bucket Count
	.long	19                              ; Header Hash Count
	.long	20                              ; Header Data Length
	.long	0                               ; HeaderData Die Offset Base
	.long	3                               ; HeaderData Atom Count
	.short	1                               ; DW_ATOM_die_offset
	.short	6                               ; DW_FORM_data4
	.short	3                               ; DW_ATOM_die_tag
	.short	5                               ; DW_FORM_data2
	.short	4                               ; DW_ATOM_type_flags
	.short	11                              ; DW_FORM_data1
	.long	0                               ; Bucket 0
	.long	2                               ; Bucket 1
	.long	5                               ; Bucket 2
	.long	8                               ; Bucket 3
	.long	9                               ; Bucket 4
	.long	11                              ; Bucket 5
	.long	13                              ; Bucket 6
	.long	14                              ; Bucket 7
	.long	16                              ; Bucket 8
	.long	1950644907                      ; Hash in Bucket 0
	.long	-1880351968                     ; Hash in Bucket 0
	.long	274395349                       ; Hash in Bucket 1
	.long	-1503406983                     ; Hash in Bucket 1
	.long	-34160304                       ; Hash in Bucket 1
	.long	193495088                       ; Hash in Bucket 2
	.long	-328142765                      ; Hash in Bucket 2
	.long	-80380739                       ; Hash in Bucket 2
	.long	2055135702                      ; Hash in Bucket 3
	.long	1750082071                      ; Hash in Bucket 4
	.long	2096540779                      ; Hash in Bucket 4
	.long	-594775205                      ; Hash in Bucket 5
	.long	-104093792                      ; Hash in Bucket 5
	.long	466678419                       ; Hash in Bucket 6
	.long	-282664779                      ; Hash in Bucket 7
	.long	-143589579                      ; Hash in Bucket 7
	.long	2089071269                      ; Hash in Bucket 8
	.long	2090147939                      ; Hash in Bucket 8
	.long	-1267332080                     ; Hash in Bucket 8
.set Lset16, Ltypes1-Ltypes_begin       ; Offset in Bucket 0
	.long	Lset16
.set Lset17, Ltypes17-Ltypes_begin      ; Offset in Bucket 0
	.long	Lset17
.set Lset18, Ltypes7-Ltypes_begin       ; Offset in Bucket 1
	.long	Lset18
.set Lset19, Ltypes11-Ltypes_begin      ; Offset in Bucket 1
	.long	Lset19
.set Lset20, Ltypes3-Ltypes_begin       ; Offset in Bucket 1
	.long	Lset20
.set Lset21, Ltypes12-Ltypes_begin      ; Offset in Bucket 2
	.long	Lset21
.set Lset22, Ltypes6-Ltypes_begin       ; Offset in Bucket 2
	.long	Lset22
.set Lset23, Ltypes14-Ltypes_begin      ; Offset in Bucket 2
	.long	Lset23
.set Lset24, Ltypes8-Ltypes_begin       ; Offset in Bucket 3
	.long	Lset24
.set Lset25, Ltypes9-Ltypes_begin       ; Offset in Bucket 4
	.long	Lset25
.set Lset26, Ltypes2-Ltypes_begin       ; Offset in Bucket 4
	.long	Lset26
.set Lset27, Ltypes13-Ltypes_begin      ; Offset in Bucket 5
	.long	Lset27
.set Lset28, Ltypes16-Ltypes_begin      ; Offset in Bucket 5
	.long	Lset28
.set Lset29, Ltypes5-Ltypes_begin       ; Offset in Bucket 6
	.long	Lset29
.set Lset30, Ltypes15-Ltypes_begin      ; Offset in Bucket 7
	.long	Lset30
.set Lset31, Ltypes10-Ltypes_begin      ; Offset in Bucket 7
	.long	Lset31
.set Lset32, Ltypes0-Ltypes_begin       ; Offset in Bucket 8
	.long	Lset32
.set Lset33, Ltypes18-Ltypes_begin      ; Offset in Bucket 8
	.long	Lset33
.set Lset34, Ltypes4-Ltypes_begin       ; Offset in Bucket 8
	.long	Lset34
Ltypes1:
	.long	383                             ; __int64_t
	.long	1                               ; Num DIEs
	.long	829
	.short	22
	.byte	0
	.long	0
Ltypes17:
	.long	770                             ; long int
	.long	1                               ; Num DIEs
	.long	1618
	.short	36
	.byte	0
	.long	0
Ltypes7:
	.long	285                             ; short
	.long	1                               ; Num DIEs
	.long	685
	.short	36
	.byte	0
	.long	0
Ltypes11:
	.long	617                             ; __darwin_va_list
	.long	1                               ; Num DIEs
	.long	1201
	.short	22
	.byte	0
	.long	0
Ltypes3:
	.long	361                             ; fpos_t
	.long	1                               ; Num DIEs
	.long	807
	.short	22
	.byte	0
	.long	0
Ltypes12:
	.long	271                             ; int
	.long	1                               ; Num DIEs
	.long	678
	.short	36
	.byte	0
	.long	0
Ltypes6:
	.long	301                             ; __sbuf
	.long	1                               ; Num DIEs
	.long	692
	.short	19
	.byte	0
	.long	0
Ltypes14:
	.long	514                             ; long unsigned int
	.long	1                               ; Num DIEs
	.long	946
	.short	36
	.byte	0
	.long	0
Ltypes8:
	.long	243                             ; __sFILE
	.long	1                               ; Num DIEs
	.long	416
	.short	19
	.byte	0
	.long	0
Ltypes9:
	.long	609                             ; va_list
	.long	1                               ; Num DIEs
	.long	1190
	.short	22
	.byte	0
	.long	0
Ltypes2:
	.long	634                             ; __builtin_va_list
	.long	1                               ; Num DIEs
	.long	1212
	.short	22
	.byte	0
	.long	0
Ltypes13:
	.long	444                             ; __ARRAY_SIZE_TYPE__
	.long	1                               ; Num DIEs
	.long	905
	.short	36
	.byte	0
	.long	0
Ltypes16:
	.long	254                             ; unsigned char
	.long	1                               ; Num DIEs
	.long	671
	.short	36
	.byte	0
	.long	0
Ltypes5:
	.long	491                             ; size_t
	.long	1                               ; Num DIEs
	.long	924
	.short	22
	.byte	0
	.long	0
Ltypes15:
	.long	498                             ; __darwin_size_t
	.long	1                               ; Num DIEs
	.long	935
	.short	22
	.byte	0
	.long	0
Ltypes10:
	.long	368                             ; __darwin_off_t
	.long	1                               ; Num DIEs
	.long	818
	.short	22
	.byte	0
	.long	0
Ltypes0:
	.long	238                             ; FILE
	.long	1                               ; Num DIEs
	.long	405
	.short	22
	.byte	0
	.long	0
Ltypes18:
	.long	350                             ; char
	.long	1                               ; Num DIEs
	.long	774
	.short	36
	.byte	0
	.long	0
Ltypes4:
	.long	393                             ; long long int
	.long	1                               ; Num DIEs
	.long	840
	.short	36
	.byte	0
	.long	0
.subsections_via_symbols
	.section	__DWARF,__debug_line,regular,debug
Lsection_line:
Lline_table_start0:
